package com.temp.pos.longterm.controllers;

//import com.temp.pos.longterm.views.SaleView;
//
//public class SaleController {
//    private final SaleView view;
//    private SaleState state = SaleState.empty();
//
//    // ✅ ALL PUBLIC OPERATIONS
//    public void addItem(LTCItemButtonMenuResult menuItem) { /* impl */ }
//    public void updateQuantity(int itemId, int quantity) { /* impl */ }
//    public void addTip(int individualUID, String associateName, double tipAmount) { /* impl */ }
//    public void assignCustomer(LTCCustomer customer) { /* impl */ }
//    public void addTender(TicketTender tender) { /* impl */ }
//    public void completeSale() { /* impl */ }
//    public void cancelSale() { /* impl */ }
//
//    public SaleState getState() { return state; }
//    public LTCPOSTicketSplit getTicket() { return state.getTicket(); }
//}   


import com.temp.pos.longterm.models.*;
import com.temp.pos.longterm.views.SaleView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.math2.double;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class SaleController {
    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    private final SaleView view;
    private SaleState state = SaleState.empty();

    public SaleController(SaleView view) {
        this.view = view;
    }

    // ITEM ACTIONS
    public void addItem(LTCItemButtonMenuResult menuItem) {
        if (menuItem == null) return;

        state = state.addItem(menuItem);
        syncItemsToTicket();
        updateView();
        logger.info("Added item: {} (ID: {})", menuItem.getSalesItemDescription(), menuItem.getSalesItemID());
    }

    public void updateQuantity(int itemId, double quantity) {
        state = state.updateQuantity(itemId, quantity);
        syncItemsToTicket();
        updateView();
    }

    public void removeItem(int itemId) {
        state = state.removeItem(itemId);
        syncItemsToTicket();
        updateView();
    }

    // TIP ACTIONS
    public void addTip(int individualUID, String associateName, double tipAmount) {
        if (tipAmount <= 0) return;

        state = state.addTip(individualUID, associateName, tipAmount);
        syncTipsToTicket();
        updateView();
        logger.info("Tip added: ${} for {}", tipAmount, associateName);
    }

    public void updateTip(int individualUID, double newTipAmount) {
        if (newTipAmount < 0) return;

        state = state.updateTip(individualUID, newTipAmount);
        syncTipsToTicket();
        updateView();
    }

    // CUSTOMER ACTIONS
    public void assignCustomer(LTCCustomer customer) {
        state = state.assignCustomer(customer);
        syncCustomerToTicket();
        updateView();

        if (customer != null) {
            view.showMessage("Customer: " + customer.getCustomerName() +
                    (customer.IsTaxExempt() ? " (Tax Exempt)" : ""));
            logger.info("Customer assigned: {} (ID: {})", customer.getCustomerName(), customer.getCustomerId());
        } else {
            view.showMessage("Guest Checkout");
        }
    }

    public void lookupCustomerById(int customerId) {
        // Replace with actual API call
        LTCCustomer customer = new LTCCustomer(); //LTCClient.getCustomerById(customerId); // Your API
        assignCustomer(customer);
    }

    // TENDER (PAYMENT) ACTIONS
    public void addTender(TicketTender tender) {
        if (tender == null || tender.getAmount() <= 0) return;

        state = state.addTender(tender);
        syncTendersToTicket();
        updateView();

        if (state.getBalanceDue() <= 0) {
            completeSale();
        }
    }

    // SALE COMPLETION
    public void completeSale() {
        LTCPOSTicketSplit ticket = state.getTicket();

        // Final sync
        syncItemsToTicket();
        syncTipsToTicket();
        syncCustomerToTicket();
        syncTendersToTicket();

        // Final totals
        double finalTotal = state.getTotal() + state.getTotalTips();
        ticket.setTotalSale(finalTotal);
        ticket.setBalanceDue(0.0);
        ticket.setTransactionDate(LocalDateTime.now());
        ticket.setTaxExempted(state.hasCustomer() && state.getCustomer().IsTaxExempt());

        // CALL API
        try {
            //TCClient.checkout(ticket); // Your API call
            view.showMessage(String.format(
                "Sale Complete!\nTotal: $%.2f | Tips: $%.2f | Customer: %s",
                finalTotal, state.getTotalTips(),
                state.hasCustomer() ? state.getCustomer().getCustomerName() : "Guest"
            ));
            logger.info("Sale completed. RRN: {}", ticket.getTicketRRN());
        } catch (Exception e) {
            view.showMessage("Checkout failed: " + e.getMessage());
            logger.error("Checkout error", e);
            return;
        }

        resetForNewSale();
        updateView();
    }

    public void cancelSale() {
        state = SaleState.empty();
        view.clearAll();
        view.showMessage("Sale Cancelled");
        view.setStatus("READY");
        logger.info("Sale cancelled by user");
    }

    // PRIVATE: Sync Methods
    private void syncItemsToTicket() {
        LTCPOSTicketSplit ticket = state.getTicket();
        ticket.setTktList(state.getItems().stream()
                .map(this::cloneItem)
                .collect(Collectors.toList()));
        ticket.setTotalSale(state.getTotal());
    }

    private void syncTipsToTicket() {
        LTCPOSTicketSplit ticket = state.getTicket();
        ticket.setAssociateTips(state.getAssociateTips().stream()
                .map(this::cloneTip)
                .collect(Collectors.toList()));
    }

    private void syncCustomerToTicket() {
        LTCPOSTicketSplit ticket = state.getTicket();
        LTCCustomer customer = state.getCustomer();
        if (customer != null) {
            ticket.setCustomerId(customer.getCustomerId());
            ticket.setCustomer(customer);
            ticket.setUpdateCustomer(true);
            ticket.setTaxExempted(customer.IsTaxExempt());
        } else {
            ticket.setCustomerId(0);
            ticket.setCustomer(null);
            ticket.setUpdateCustomer(false);
            ticket.setTaxExempted(false);
        }
    }

    private void syncTendersToTicket() {
        LTCPOSTicketSplit ticket = state.getTicket();
        ticket.setTicketTenderList(state.getTenders().stream()
                .map(this::cloneTender)
                .collect(Collectors.toList()));
    }

    // PRIVATE: Deep Clone Helpers (to avoid reference sharing)
    private SalesTransactionCheckoutItem cloneItem(SalesTransactionCheckoutItem src) {
        SalesTransactionCheckoutItem dest = new SalesTransactionCheckoutItem();
        dest.setSalesItemID(src.getSalesItemID());
        dest.setSalesItemDescription(src.getSalesItemDescription());
        dest.setQuantity(src.getQuantity());
        dest.setUnitPrice(src.getUnitPrice());
        dest.setLineTotal(src.getLineTotal());
        dest.setTaxAmount(src.getTaxAmount());
        dest.setDiscountAmount(src.getDiscountAmount());
        dest.setTaxExempt(src.isTaxExempt());
        return dest;
    }

    private AssociateSaleTips cloneTip(AssociateSaleTips src) {
        AssociateSaleTips dest = new AssociateSaleTips();
        dest.setIndividualUID(src.getIndividualUID());
        dest.setAssociateName(src.getAssociateName());
        dest.setTipAmount(src.getTipAmount());
        dest.setTipPercentage(src.getTipPercentage());
        dest.setSalesItemCount(src.getSalesItemCount());
        dest.setTotalSaleAmount(src.getTotalSaleAmount());
        return dest;
    }

    private TicketTender cloneTender(TicketTender src) {
        TicketTender dest = new TicketTender();
        dest.setAmount(src.getAmount());
        // Copy other fields as needed
        return dest;
    }

    // PRIVATE: UI Update
    private void updateView() {
        view.updateBilling(state);
        view.setStatus(state.getStatus().name());
    }

    // PRIVATE: Reset
    private void resetForNewSale() {
        state = SaleState.empty();
    }

    // EXPOSE STATE (for testing or advanced UI)
    public SaleState getCurrentState() {
        return state;
    }

    public LTCPOSTicketSplit getCurrentTicket() {
        return state.getTicket();
    }
}
