package com.temp.pos.longterm.models;

public class TranSaveStatus {
    private boolean ticketTranSaved;
    private int transactionId;
    private int ticketNumber;

    // Getters and Setters
    public boolean isTicketTranSaved() {
        return ticketTranSaved;
    }

    public void setTicketTranSaved(boolean ticketTranSaved) {
        this.ticketTranSaved = ticketTranSaved;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}