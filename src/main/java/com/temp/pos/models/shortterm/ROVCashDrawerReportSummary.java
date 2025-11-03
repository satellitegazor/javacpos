package com.temp.pos.models.shortterm;

import java.util.List;

public class ROVCashDrawerReportSummary {
    private List<ROVCashDrawerDetails> cashDrawerDetails;

    // Getters and Setters
    public List<ROVCashDrawerDetails> getCashDrawerDetails() {
        return cashDrawerDetails;
    }

    public void setCashDrawerDetails(List<ROVCashDrawerDetails> cashDrawerDetails) {
        this.cashDrawerDetails = cashDrawerDetails;
    }
}