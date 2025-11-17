package com.temp.pos.longterm.models;
import com.temp.pos.models.common.ExchCardTndr;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LTCPOSTicketSplit {
    private String ticketRRN;                // Reference Number
    private LocalDateTime transactionDate;   // Transaction date/time
    private int individualUID;               // Associate/User ID
    private int locationUID;                 // Location ID
    private boolean taxExempted;             // Tax exemption status
    private int transactionID;               // Transaction ID
    private int cancelTransactionID;         // Cancelled transaction ID
    private boolean isRefund;                // Indicates if it's a refund
    private double balanceDue;               // Remaining balance
    private String instructions;             // Additional instructions
    private List<TicketTender> ticketTenderList;  // List of tenders
    private boolean updateCustomer;          // Flag to update customer
    private int customerId;                  // Customer ID
    private LTCCustomer customer;            // Customer object
    private double totalSale;                // Total sale amount
    private double totalSaleFC;              // Total sale in foreign currency
    private List<SalesTransactionCheckoutItem> tktList;  // List of sale items
    private String refundReason;             // Reason for refund
    private String refundCode;               // Refund code
    private boolean isPartialPay;            // Indicates partial payment
    private double partialAmount;            // Partial payment amount
    private double partialAmountFC;          // Partial payment in foreign currency
    private boolean updateCoupons;           // Flag to update coupons
    private List<AssociateSaleTips> associateTips;  // List of tips
    private double tCouponPerc;              // Total coupon percentage
    private double tCouponAmt;               // Total coupon amount
    private double tDCouponAmt;              // Total discount coupon amount
    private int cliTimeVar;                  // Client time variation
    private double shipHandling;             // Shipping/handling fee
    private double shipHandlingTaxAmt;       // Shipping/handling tax amount
    private double shipHandlingFC;           // Shipping/handling in foreign currency
    private double shipHandlingTaxAmtFC;     // Shipping/handling tax in foreign currency
    private ExchCardTndr vmTndr;             // Value-added method tender (e.g., gift card)

    // Default Constructor
    public LTCPOSTicketSplit() {
        this.ticketTenderList = new ArrayList<>();
        this.tktList = new ArrayList<>();
        this.associateTips = new ArrayList<>();
        this.transactionDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getTicketRRN() { return ticketRRN; }
    public void setTicketRRN(String ticketRRN) { this.ticketRRN = ticketRRN; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }

    public int getIndividualUID() { return individualUID; }
    public void setIndividualUID(int individualUID) { this.individualUID = individualUID; }

    public int getLocationUID() { return locationUID; }
    public void setLocationUID(int locationUID) { this.locationUID = locationUID; }

    public boolean isTaxExempted() { return taxExempted; }
    public void setTaxExempted(boolean taxExempted) { this.taxExempted = taxExempted; }

    public int getTransactionID() { return transactionID; }
    public void setTransactionID(int transactionID) { this.transactionID = transactionID; }

    public int getCancelTransactionID() { return cancelTransactionID; }
    public void setCancelTransactionID(int cancelTransactionID) { this.cancelTransactionID = cancelTransactionID; }

    public boolean isRefund() { return isRefund; }
    public void setRefund(boolean isRefund) { this.isRefund = isRefund; }

    public double getBalanceDue() { return balanceDue; }
    public void setBalanceDue(double balanceDue) { this.balanceDue = balanceDue; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public List<TicketTender> getTicketTenderList() { return ticketTenderList; }
    public void setTicketTenderList(List<TicketTender> ticketTenderList) { this.ticketTenderList = ticketTenderList; }

    public boolean isUpdateCustomer() { return updateCustomer; }
    public void setUpdateCustomer(boolean updateCustomer) { this.updateCustomer = updateCustomer; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public LTCCustomer getCustomer() { return customer; }
    public void setCustomer(LTCCustomer customer) { this.customer = customer; }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) { this.totalSale = totalSale; }

    public double getTotalSaleFC() { return totalSaleFC; }
    public void setTotalSaleFC(double totalSaleFC) { this.totalSaleFC = totalSaleFC; }

    public List<SalesTransactionCheckoutItem> getTktList() { return tktList; }
    public void setTktList(List<SalesTransactionCheckoutItem> tktList) { this.tktList = tktList; }

    public String getRefundReason() { return refundReason; }
    public void setRefundReason(String refundReason) { this.refundReason = refundReason; }

    public String getRefundCode() { return refundCode; }
    public void setRefundCode(String refundCode) { this.refundCode = refundCode; }

    public boolean isPartialPay() { return isPartialPay; }
    public void setPartialPay(boolean isPartialPay) { this.isPartialPay = isPartialPay; }

    public double getPartialAmount() { return partialAmount; }
    public void setPartialAmount(double partialAmount) { this.partialAmount = partialAmount; }

    public double getPartialAmountFC() { return partialAmountFC; }
    public void setPartialAmountFC(double partialAmountFC) { this.partialAmountFC = partialAmountFC; }

    public boolean isUpdateCoupons() { return updateCoupons; }
    public void setUpdateCoupons(boolean updateCoupons) { this.updateCoupons = updateCoupons; }

    public List<AssociateSaleTips> getAssociateTips() { return associateTips; }
    public void setAssociateTips(List<AssociateSaleTips> associateTips) { this.associateTips = associateTips; }

    public double getTCouponPerc() { return tCouponPerc; }
    public void setTCouponPerc(double tCouponPerc) { this.tCouponPerc = tCouponPerc; }

    public double getTCouponAmt() { return tCouponAmt; }
    public void setTCouponAmt(double tCouponAmt) { this.tCouponAmt = tCouponAmt; }

    public double getTDCouponAmt() { return tDCouponAmt; }
    public void setTDCouponAmt(double tDCouponAmt) { this.tDCouponAmt = tDCouponAmt; }

    public int getCliTimeVar() { return cliTimeVar; }
    public void setCliTimeVar(int cliTimeVar) { this.cliTimeVar = cliTimeVar; }

    public double getShipHandling() { return shipHandling; }
    public void setShipHandling(double shipHandling) { this.shipHandling = shipHandling; }

    public double getShipHandlingTaxAmt() { return shipHandlingTaxAmt; }
    public void setShipHandlingTaxAmt(double shipHandlingTaxAmt) { this.shipHandlingTaxAmt = shipHandlingTaxAmt; }

    public double getShipHandlingFC() { return shipHandlingFC; }
    public void setShipHandlingFC(double shipHandlingFC) { this.shipHandlingFC = shipHandlingFC; }

    public double getShipHandlingTaxAmtFC() { return shipHandlingTaxAmtFC; }
    public void setShipHandlingTaxAmtFC(double shipHandlingTaxAmtFC) { this.shipHandlingTaxAmtFC = shipHandlingTaxAmtFC; }

    public ExchCardTndr getVmTndr() { return vmTndr; }
    public void setVmTndr(ExchCardTndr vmTndr) { this.vmTndr = vmTndr; }

    public List<SalesTransactionCheckoutItem> getItems() {
        return this.tktList;
    }
    public void setItems(List<SalesTransactionCheckoutItem> items) {
        this.tktList = items;
    }
    public List<TicketTender> getTenders() {
        return this.ticketTenderList;
    }
    public void setTenders(List<TicketTender> tenders) {
        this.ticketTenderList = tenders;
    }

    public double getTotal() {
        return totalSale;
    }
    public void setTotal(double Total) {
        totalSale = Total;
    }



    public LTCPOSTicketSplit copy() {
        LTCPOSTicketSplit copy = new LTCPOSTicketSplit();
        copy.setItems(new ArrayList<>(this.getItems()));
        copy.setAssociateTips(new ArrayList<>(this.getAssociateTips()));
        copy.setTenders(new ArrayList<>(this.getTenders()));
        copy.setCustomer(this.getCustomer());
        copy.setCustomerId(this.getCustomerId());
        copy.setTaxExempted(this.isTaxExempted());
        //copy.setStatus(this.getStatus());
        // copy other fields as needed
        return copy;
    }

    public void recalculateTotals() {
        double itemsTotal = getItems().stream()
                .mapToDouble(SalesTransactionCheckoutItem::getLineTotal)
                .sum();

        double tipsTotal = getAssociateTips().stream()
                .mapToDouble(AssociateSaleTips::getTipAmount)
                .sum();

        double paid = getTenders().stream()
                .mapToDouble(TicketTender::getAmount)
                .sum();

        double tax = isTaxExempted() ? 0 : itemsTotal * 0.06; // example tax rate
        double grandTotal = itemsTotal + tax + tipsTotal;

        setTotal(grandTotal);
        //setTotalTips(tipsTotal);
        setBalanceDue(grandTotal - paid);
    }
}