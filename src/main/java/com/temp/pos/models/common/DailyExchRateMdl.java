package com.temp.pos.models.common;

public class DailyExchRateMdl {
        private MobileBase results;
    // Placeholder: Add fields as per JSON structure
    private double exchangeRate;
    private String foreignCurrCode;

    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getForeignCurrCode() {
        return foreignCurrCode;
    }

    public void setForeignCurrCode(String foreignCurrCode) {
        this.foreignCurrCode = foreignCurrCode;
    }
}
