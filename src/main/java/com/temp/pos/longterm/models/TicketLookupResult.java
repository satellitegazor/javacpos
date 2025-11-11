package com.temp.pos.longterm.models;

import java.util.ArrayList;
import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class TicketLookupResult {
    private MobileBase results;
    private List<TicketLookupModel> tickets;

    public TicketLookupResult() {
        tickets = new ArrayList<>();
    }

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<TicketLookupModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketLookupModel> tickets) {
        this.tickets = tickets;
    }
}