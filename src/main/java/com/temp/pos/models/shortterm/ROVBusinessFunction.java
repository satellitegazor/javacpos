package com.temp.pos.models.shortterm;

public class ROVBusinessFunction {
    private int businessFunctionUID;
    private String code;
    private String description;
    private String displayOrder;
    private String businessModel;
    private boolean allowShipHandling;
    private boolean allowInsurance;

    // Getters and Setters
    public int getBusinessFunctionUID() {
        return businessFunctionUID;
    }

    public void setBusinessFunctionUID(int businessFunctionUID) {
        this.businessFunctionUID = businessFunctionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public boolean isAllowShipHandling() {
        return allowShipHandling;
    }

    public void setAllowShipHandling(boolean allowShipHandling) {
        this.allowShipHandling = allowShipHandling;
    }

    public boolean isAllowInsurance() {
        return allowInsurance;
    }

    public void setAllowInsurance(boolean allowInsurance) {
        this.allowInsurance = allowInsurance;
    }
}