package com.temp.pos.models.longterm;

public class SaveTenderResult {
    private long ticketTenderId;
    private long partPayId;
    private String rrn;

    // Getters and Setters
    public long getTicketTenderId() {
        return ticketTenderId;
    }

    public void setTicketTenderId(long ticketTenderId) {
        this.ticketTenderId = ticketTenderId;
    }

    public long getPartPayId() {
        return partPayId;
    }

    public void setPartPayId(long partPayId) {
        this.partPayId = partPayId;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}