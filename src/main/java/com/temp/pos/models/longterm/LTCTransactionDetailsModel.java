package com.temp.pos.models.longterm;

import com.temp.pos.models.common.MobileBase;

public class LTCTransactionDetailsModel {
    private MobileBase results;
    // Placeholder: Add fields as per JSON structure
    private int transactionId;

    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}