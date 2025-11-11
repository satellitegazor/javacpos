package com.temp.pos.longterm.models;

import com.temp.pos.models.common.MobileBase;

public class VendorContractSummaryResultsModel {
    private MobileBase results;
    private ContractSummaryReport summary;

    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public ContractSummaryReport getSummary() {
        return summary;
    }

    public void setSummary(ContractSummaryReport summary) {
        this.summary = summary;
    }
}