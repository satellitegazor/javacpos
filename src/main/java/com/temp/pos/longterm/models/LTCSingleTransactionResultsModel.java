package com.temp.pos.longterm.models;

import com.temp.pos.models.common.MobileBase;

public class LTCSingleTransactionResultsModel {
    private MobileBase results;
    private LTCTicket ticket;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public LTCTicket getTicket() {
        return ticket;
    }

    public void setTicket(LTCTicket ticket) {
        this.ticket = ticket;
    }
}