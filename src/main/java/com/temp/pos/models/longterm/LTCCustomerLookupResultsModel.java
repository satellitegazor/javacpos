package com.temp.pos.models.longterm;

import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class LTCCustomerLookupResultsModel {
    private MobileBase results;
    private List<LTCCustomer> customers;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<LTCCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<LTCCustomer> customers) {
        this.customers = customers;
    }
}