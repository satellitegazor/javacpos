package com.temp.pos.models.shortterm;

import com.temp.pos.models.common.MobileBase;

public class ROVCashDrawerSummaryResultsModel {
    private MobileBase results;
    private ROVCashDrawerReportSummary summary;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public ROVCashDrawerReportSummary getSummary() {
        return summary;
    }

    public void setSummary(ROVCashDrawerReportSummary summary) {
        this.summary = summary;
    }
}