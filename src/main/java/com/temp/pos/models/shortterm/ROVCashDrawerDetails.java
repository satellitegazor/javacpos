package com.temp.pos.models.shortterm;

import java.sql.Date;

public class ROVCashDrawerDetails {
    private double tenderAmount;
    private double depositCashCheck;
    private String tenderDesc;
    private Date transDate;
    private Date businessDate;
    private String facNumber;
    private String associate;
    private boolean isExisting;
    private String configDate;

    // Getters and Setters
    public double getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(double tenderAmount) {
        this.tenderAmount = tenderAmount;
    }

    public double getDepositCashCheck() {
        return depositCashCheck;
    }

    public void setDepositCashCheck(double depositCashCheck) {
        this.depositCashCheck = depositCashCheck;
    }

    public String getTenderDesc() {
        return tenderDesc;
    }

    public void setTenderDesc(String tenderDesc) {
        this.tenderDesc = tenderDesc;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public String getAssociate() {
        return associate;
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }

    public boolean isExisting() {
        return isExisting;
    }

    public void setExisting(boolean existing) {
        isExisting = existing;
    }

    public String getConfigDate() {
        return configDate;
    }

    public void setConfigDate(String configDate) {
        this.configDate = configDate;
    }
}