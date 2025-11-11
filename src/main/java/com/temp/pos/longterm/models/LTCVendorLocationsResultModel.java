package com.temp.pos.longterm.models;

import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class LTCVendorLocationsResultModel {
    private MobileBase results;
    private List<LTCAbbrLocationModel> locations;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<LTCAbbrLocationModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LTCAbbrLocationModel> locations) {
        this.locations = locations;
    }
}