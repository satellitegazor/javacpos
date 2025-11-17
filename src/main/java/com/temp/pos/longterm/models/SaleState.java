// src/main/java/com/temp/pos/longterm/models/SaleState.java
package com.temp.pos.longterm.models;

import com.temp.pos.models.common.SaleStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class SaleState {
    private final LTCPOSTicketSplit ticket;

    // Private constructor – forces use of factory methods
    private SaleState(LTCPOSTicketSplit ticket) {
        this.ticket = ticket != null ? ticket : new LTCPOSTicketSplit();
    }

    // Factory: empty state
    public static SaleState empty() {
        LTCPOSTicketSplit ticket = new LTCPOSTicketSplit();
        //ticket.setStatus(SaleStatus.NEW);
        return new SaleState(ticket);
    }

    // From existing ticket (e.g., after load from DB/API)
    public static SaleState fromTicket(LTCPOSTicketSplit ticket) {
        return new SaleState(ticket);
    }

    // ITEM OPERATIONS – delegate to ticket
    public SaleState addItem(LTCItemButtonMenuResult menuItem) {
        LTCPOSTicketSplit newTicket = ticket.copy();

        Optional<SalesTransactionCheckoutItem> existing = newTicket.getItems().stream()
                .filter(i -> i.getSalesItemID() == menuItem.getSalesItemID())
                .findFirst();

        if (existing.isPresent()) {
            SalesTransactionCheckoutItem item = existing.get();
            item.setQuantity(item.getQuantity() + 1);
            item.setLineTotal(item.getUnitPrice() * item.getQuantity());
        } else {
            SalesTransactionCheckoutItem newItem = new SalesTransactionCheckoutItem();
            newItem.setSalesItemID(menuItem.getSalesItemID());
            newItem.setSalesItemDescription(menuItem.getSalesItemDescription());
            newItem.setQuantity(1);
            newItem.setUnitPrice(menuItem.getPrice());
            newItem.setLineTotal(menuItem.getPrice());
            newTicket.getItems().add(newItem);
        }

        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    public SaleState removeItem(int itemId) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getItems().removeIf(i -> i.getSalesItemID() == itemId);
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    public SaleState updateQuantity(int itemId, double quantity) {
        if (quantity <= 0) return removeItem(itemId);

        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getItems().stream()
                .filter(i -> i.getSalesItemID() == itemId)
                .findFirst()
                .ifPresent(item -> {
                    item.setQuantity(quantity);
                    item.setLineTotal(item.getUnitPrice() * quantity);
                });
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    // CUSTOMER
    public SaleState assignCustomer(LTCCustomer customer) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.setCustomer(customer);
        newTicket.setCustomerId(customer != null ? customer.getCustomerId() : 0);
        newTicket.setUpdateCustomer(customer != null);
        //newTicket.setTaxExempted(customer != null && customer.isTaxExempt());
        newTicket.recalculateTotals(); // tax may change
        return new SaleState(newTicket);
    }

    public SaleState clearCustomer() {
        return assignCustomer(null);
    }

    // TIPS
    public SaleState addTip(AssociateSaleTips tip) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getAssociateTips().add(tip);
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    public SaleState updateTip(int individualId, double newAmount) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getAssociateTips().stream()
                .filter(t -> (t.getIndividualUID() == individualId))
                .findFirst()
                .ifPresent(t -> t.setTipAmount(newAmount));
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    public double getTotalTips() {
        double totalTipAmount = 0;
        totalTipAmount = ticket.copy().getAssociateTips().stream().mapToDouble(AssociateSaleTips::getTipAmount).sum();
        return totalTipAmount;
    }

    // TENDERS
    public SaleState addTender(TicketTender tender) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getTenders().add(tender);
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    public SaleState clearTenders() {
        LTCPOSTicketSplit newTicket = ticket.copy();
        newTicket.getTenders().clear();
        newTicket.recalculateTotals();
        return new SaleState(newTicket);
    }

    // STATUS
    public SaleState setStatus(SaleStatus status) {
        LTCPOSTicketSplit newTicket = ticket.copy();
        //newTicket.setStatus(status);
        return new SaleState(newTicket);
    }

    // GETTERS – all delegated to ticket
    public List<SalesTransactionCheckoutItem> getItems()         { return List.copyOf(ticket.getItems()); }
    public List<AssociateSaleTips>       getAssociateTips()    { return List.copyOf(ticket.getAssociateTips()); }
    public LTCCustomer                   getCustomer()          { return ticket.getCustomer(); }
    public LTCPOSTicketSplit             getTicket()            { return ticket; }
    public double                        getTotal()             { return ticket.getTotal(); }
    public double                        getBalanceDue()        { return ticket.getBalanceDue(); }
    //public double                        getTotalTips()         { return ticket.getTotalTips(); }
    public List<TicketTender>            getTenders()           { return List.copyOf(ticket.getTenders()); }
    //public SaleStatus                    getStatus()            { return ticket.getStatus(); }
    public boolean                       hasCustomer()          { return ticket.getCustomer() != null; }
    public boolean                       isPaid()               { return ticket.getBalanceDue() <= 0; }
}