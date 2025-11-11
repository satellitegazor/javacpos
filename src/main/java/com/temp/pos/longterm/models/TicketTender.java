package com.temp.pos.longterm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketTender {
        private int tenderTransactionId;
    // Placeholder: Add fields as per JSON structure
    private String tenderType;
    private double amount;

    @JsonProperty("TenderTransactionId")
    public int getTenderTransactionId() {
        return tenderTransactionId;
    }

    public void setTenderTransactionId(int tenderTransactionId) {
        this.tenderTransactionId = tenderTransactionId;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
