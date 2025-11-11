package com.temp.pos.longterm.models;

public class TicketLookupModel {
    private int transactionID;
    private int ticketNumber;
    private int locationUID;

    // Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(int locationUID) {
        this.locationUID = locationUID;
    }
}