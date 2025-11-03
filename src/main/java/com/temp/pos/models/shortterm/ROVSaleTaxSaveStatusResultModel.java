package com.temp.pos.models.shortterm;

import com.temp.pos.models.common.MobileBase;

public class ROVSaleTaxSaveStatusResultModel {
    private MobileBase results;
    private boolean  saleTaxSaveStatus;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public boolean getSaleTaxSaveStatus() {
        return saleTaxSaveStatus;
    }

    public void setSaleTaxSaveStatus(boolean saleTaxSaveStatus) {
        this.saleTaxSaveStatus = saleTaxSaveStatus;
    }
}