package com.temp.pos.models.longterm;

import com.temp.pos.models.common.MobileBase;

public class SystemStatusResultsModel {
    private MobileBase results;
    private SystemStatus status;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public SystemStatus getStatus() {
        return status;
    }

    public void setStatus(SystemStatus status) {
        this.status = status;
    }
}