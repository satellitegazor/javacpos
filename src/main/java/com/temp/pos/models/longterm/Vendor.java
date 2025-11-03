package com.temp.pos.models.longterm;

public class Vendor {
    private int id;
    private boolean hasUpdates;
    private String vendorEPaid;
    private String bankCode;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }

    public String getVendorEPaid() {
        return vendorEPaid;
    }

    public void setVendorEPaid(String vendorEPaid) {
        this.vendorEPaid = vendorEPaid;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}