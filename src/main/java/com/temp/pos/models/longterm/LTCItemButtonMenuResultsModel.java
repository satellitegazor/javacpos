package com.temp.pos.models.longterm;

import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class LTCItemButtonMenuResultsModel {
    private MobileBase results;
    private List<LTCItemButtonMenuResult> itemButtonMenuResults;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<LTCItemButtonMenuResult> getItemButtonMenuResults() {
        return itemButtonMenuResults;
    }

    public void setItemButtonMenuResults(List<LTCItemButtonMenuResult> itemButtonMenuResults) {
        this.itemButtonMenuResults = itemButtonMenuResults;
    }
}