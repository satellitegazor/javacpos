package com.temp.pos.models.longterm;

import com.temp.pos.models.common.MobileBase;

public class SaveTenderResultModel {
    private MobileBase results;
    private SaveTenderResult data;

    public SaveTenderResultModel() {
        results = new MobileBase();
        results.setSuccess(false);
    }

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public SaveTenderResult getData() {
        return data;
    }

    public void setData(SaveTenderResult data) {
        this.data = data;
    }
}