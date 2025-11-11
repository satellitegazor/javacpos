package com.temp.pos.longterm.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.temp.pos.models.common.MobileBase;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LTCCustomerLookupResultsModel {

    @JsonProperty("results")
    private MobileBase results;

    @JsonProperty("customers")
    private List<LTCCustomer> customers;

    // === GETTERS & SETTERS ===
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