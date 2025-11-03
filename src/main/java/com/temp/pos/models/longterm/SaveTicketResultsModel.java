package com.temp.pos.models.longterm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.temp.pos.models.common.MobileBase;

public class SaveTicketResultsModel {
    // Placeholder for fields, as not defined in provided code
        private MobileBase results;
    private String posAuthNumber;
    private String posResponse;

    @JsonProperty("POSAuthNumber")
    public String getPOSAuthNumber() {
        return posAuthNumber;
    }

    public void setPOSAuthNumber(String posAuthNumber) {
        this.posAuthNumber = posAuthNumber;
    }

    @JsonProperty("POSResponse")
    public String getPOSResponse() {
        return posResponse;
    }

    public void setPOSResponse(String posResponse) {
        this.posResponse = posResponse;
    }

    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }
}