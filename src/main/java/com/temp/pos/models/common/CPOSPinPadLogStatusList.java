package com.temp.pos.models.common;

import java.util.List;

public class CPOSPinPadLogStatusList {
    private MobileBase results;
    private List<CPOSPinPadLogStatus> pinPadLogList;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<CPOSPinPadLogStatus> getPinPadLogList() {
        return pinPadLogList;
    }

    public void setPinPadLogList(List<CPOSPinPadLogStatus> pinPadLogList) {
        this.pinPadLogList = pinPadLogList;
    }
}