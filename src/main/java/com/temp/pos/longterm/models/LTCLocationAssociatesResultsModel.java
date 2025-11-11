package com.temp.pos.longterm.models;

import java.util.List;

import com.temp.pos.models.common.MobileBase;


public class LTCLocationAssociatesResultsModel {
    private MobileBase results;
    private List<LTCLocationAssociate> associates;

    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<LTCLocationAssociate> getAssociates() {
        return associates;
    }

    public void setAssociates(List<LTCLocationAssociate> associates) {
        this.associates = associates;
    }
}