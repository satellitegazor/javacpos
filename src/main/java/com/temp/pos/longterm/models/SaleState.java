package com.temp.pos.longterm.models;

import java.util.*;
import java.util.stream.Collectors;

import com.temp.pos.models.common.SaleStatus;

public final class SaleState {
    private final List<SalesTransactionCheckoutItem> items;
    private final List<AssociateSaleTips> associateTips;
    private final LTCCustomer customer;
    private final LTCPOSTicketSplit ticket;
    private final double total;
    private final double balanceDue;
    private final double totalTips;
    private final List<TicketTender> tenders;
    private final SaleStatus status;

    public static SaleState empty() {
        return new SaleState(List.of(), List.of(), null, new LTCPOSTicketSplit(),
                0, 0, 0, List.of(), SaleStatus.NEW);
    }

    // 🛒 ITEM OPERATIONS
    public SaleState addItem(LTCItemButtonMenuResult menuItem) {
        var newItems = new ArrayList<>(items);
        Optional<SalesTransactionCheckoutItem> existing = newItems.stream()
            .filter(item -> item.getSalesItemID() == menuItem.getSalesItemID())
            .findFirst();
        
        if (existing.isPresent()) {
            SalesTransactionCheckoutItem updated = existing.get();
            updated.setQuantity(updated.getQuantity() + 1);
            newItems.remove(existing.get());
            newItems.add(updated);
        } else {
            SalesTransactionCheckoutItem newItem = new SalesTransactionCheckoutItem(
                menuItem.getSalesItemID(),
                menuItem.getSalesItemDescription(),
                1,
                menuItem.getPrice()
            );
            newItems.add(newItem);
        }
        
        return new SaleState(newItems, associateTips, customer, ticket, recalculateTotal(newItems),
                balanceDue, totalTips, tenders, status);
    }

    public SaleState removeItem(int itemId) {
        var newItems = items.stream()
            .filter(item -> item.getSalesItemID() != itemId)
            .collect(Collectors.toList());
        return new SaleState(newItems, associateTips, customer, ticket, recalculateTotal(newItems),
                balanceDue, totalTips, tenders, status);
    }

    public SaleState updateQuantity(int itemId, double quantity) {
        if (quantity <= 0) return removeItem(itemId);
        
        var newItems = items.stream()
            .map(item -> item.getSalesItemID() == itemId ? 
                createUpdatedItem(item, quantity) : item)
            .collect(Collectors.toList());
        return new SaleState(newItems, associateTips, customer, ticket, recalculateTotal(newItems),
                balanceDue, totalTips, tenders, status);
    }

    private SalesTransactionCheckoutItem createUpdatedItem(SalesTransactionCheckoutItem item, double quantity) {
        SalesTransactionCheckoutItem updated = new SalesTransactionCheckoutItem();
        updated.setSalesItemID(item.getSalesItemID());
        updated.setSalesItemDescription(item.getSalesItemDescription());
        updated.setQuantity(quantity);
        updated.setUnitPrice(item.getUnitPrice());
        return updated;
    }

    // 💰 TIP OPERATIONS
    public SaleState addTip(int individualUID, String associateName, double tipAmount) {
        var newTips = new ArrayList<>(associateTips);
        Optional<AssociateSaleTips> existing = newTips.stream()
            .filter(tip -> tip.getIndividualUID() == individualUID)
            .findFirst();
        
        if (existing.isPresent()) {
            AssociateSaleTips updated = existing.get();
            updated.setTipAmount(updated.getTipAmount() + tipAmount);
            newTips.remove(existing.get());
            newTips.add(updated);
        } else {
            AssociateSaleTips newTip = new AssociateSaleTips(individualUID, associateName, tipAmount);
            newTips.add(newTip);
        }
        
        return new SaleState(items, newTips, customer, ticket, total,
                balanceDue, calculateTotalTips(newTips), tenders, status);
    }

    public SaleState updateTip(int individualUID, double newTipAmount) {
        var newTips = associateTips.stream()
            .map(tip -> tip.getIndividualUID() == individualUID ? 
                createUpdatedTip(tip, newTipAmount) : tip)
            .collect(Collectors.toList());
        return new SaleState(items, newTips, customer, ticket, total,
                balanceDue, calculateTotalTips(newTips), tenders, status);
    }

    private AssociateSaleTips createUpdatedTip(AssociateSaleTips tip, double newTipAmount) {
        AssociateSaleTips updated = new AssociateSaleTips();
        updated.setIndividualUID(tip.getIndividualUID());
        updated.setAssociateName(tip.getAssociateName());
        updated.setTipAmount(newTipAmount);
        updated.setSalesItemCount(tip.getSalesItemCount());
        updated.setTotalSaleAmount(tip.getTotalSaleAmount());
        return updated;
    }

    // 👤 CUSTOMER OPERATIONS
    public SaleState assignCustomer(LTCCustomer customer) {
        LTCPOSTicketSplit updatedTicket = new LTCPOSTicketSplit();
        updatedTicket.setCustomerId(customer != null ? customer.getCustomerId() : 0);
        updatedTicket.setUpdateCustomer(customer != null);
        updatedTicket.setCustomer(customer);
        updatedTicket.setTaxExempted(customer != null && customer.IsTaxExempt());
        
        return new SaleState(items, associateTips, customer, updatedTicket, total,
                balanceDue, totalTips, tenders, status);
    }

    // 💳 TENDER OPERATIONS
    public SaleState addTender(TicketTender tender) {
        var newTenders = new ArrayList<>(tenders);
        newTenders.add(tender);
        var newBalance = balanceDue - tender.getAmount();
        return new SaleState(items, associateTips, customer, ticket, total,
                newBalance, totalTips, newTenders, status);
    }

    // PRIVATE CALCULATIONS
    private double recalculateTotal(List<SalesTransactionCheckoutItem> items) {
        return 0;
//        return items.stream()
//            .map(item -> double.valueOf(item.getLineTotal()))
//            .reduce(double.ZERO, double::add);
    }

    private double calculateTotalTips(List<AssociateSaleTips> tips) {
        return 0;
//        return tips.stream()
//            .map(tip -> double.valueOf(tip.getTipAmount()))
//            .reduce(double.ZERO, double::add);
    }

    // CONSTRUCTOR (IMMUTABLE)
    private SaleState(List<SalesTransactionCheckoutItem> items, List<AssociateSaleTips> associateTips,
                     LTCCustomer customer, LTCPOSTicketSplit ticket, double total,
                     double balanceDue, double totalTips, List<TicketTender> tenders,
                     SaleStatus status) {
        this.associateTips = associateTips;
        this.items = items;
        this.customer = customer;
        this.ticket = ticket;
        this.total = total;
        this.balanceDue = balanceDue;
        this.totalTips = totalTips;
        this.tenders = List.copyOf(tenders);
        this.status = status;
    }

    // GETTERS
    public List<SalesTransactionCheckoutItem> getItems() { return items; }
    public List<AssociateSaleTips> getAssociateTips() { return associateTips; }
    public LTCCustomer getCustomer() { return customer; }
    public LTCPOSTicketSplit getTicket() { return ticket; }
    public double getTotal() { return total; }
    public double getBalanceDue() { return balanceDue; }
    public double getTotalTips() { return totalTips; }
    public List<TicketTender> getTenders() { return tenders; }
    public SaleStatus getStatus() { return status; }
    public boolean hasCustomer() { return customer != null; }
}