package com.temp.pos.longterm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Minimal LTCCustomer – only the fields you listed.
 */
public class LTCCustomer {

    // === FIELDS (exactly as you wrote them) ===
    @JsonProperty("customerUID")
    private int    customerUID;
    @JsonProperty("cTitle")
    private String cTitle;
    @JsonProperty("cFirstName")
    private String cFirstName;
    @JsonProperty("cLastName")
    private String cLastName;
    @JsonProperty("cAddress1")
    private String cAddress1;
    @JsonProperty("cAddress2")
    private String cAddress2;
    @JsonProperty("cCity")
    private String cCity;
    @JsonProperty("cStateProvice")
    private String cStateProvince;
    @JsonProperty("cPostalCode")
    private String cPostalCode;
    @JsonProperty("cEmailAddress")
    private String cEmailAddress;
    @JsonProperty("cPhoneNumber")
    private String cPhoneNumber;
    @JsonProperty("cDialCode")
    private String cDialCode = "";
    @JsonProperty("cNotes")
    private String cNotes = "";
    @JsonProperty("cUnit")
    private String cUnit = "";
    @JsonProperty("cmi")
    private String cmi = "";   // <-- fixed missing semicolon
    private boolean isTaxExempt = false;

    // === CONSTRUCTORS ===
    public LTCCustomer() {}

    public LTCCustomer(int customerUID, String firstName, 
            String lastName, String phoneNum) {
        this.customerUID   = customerUID;
        this.cFirstName    = firstName;
        this.cLastName     = lastName;
        this.cPhoneNumber  = phoneNum;
    }

    // === GETTERS (the ones you already had) ===
    public int    getCustomerId()   { return customerUID; }
    public String getCustomerName() { return (cFirstName != null ? cFirstName : "") + " " + (cLastName != null ? cLastName : ""); }
    public String getFirstName()    { return cFirstName; }
    public String getLastName()     { return cLastName; }
    public String getEmail()        { return cEmailAddress; }
    public String getPhone()        { return cPhoneNumber; }
    public String getAddress1()     { return cAddress1; }
    public String getAddress2()     { return cAddress2; }
    public String getCity()         { return cCity; }
    public String getState()        { return cStateProvince; }
    public String getZipCode()      { return cPostalCode; }
    public boolean IsTaxExempt() { return isTaxExempt;}

    // === SETTERS – ONE FOR EVERY FIELD ===
    public void setCustomerId(int customerUID) {
        this.customerUID = customerUID;
    }

    public void setTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public void setFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public void setLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public void setEmail(String cEmailAddress) {
        this.cEmailAddress = cEmailAddress;
    }

    public void setPhone(String cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public void setAddress1(String cAddress1) {
        this.cAddress1 = cAddress1;
    }

    public void setAddress2(String cAddress2) {
        this.cAddress2 = cAddress2;
    }

    public void setCity(String cCity) {
        this.cCity = cCity;
    }

    public void setState(String cStateProvince) {
        this.cStateProvince = cStateProvince;
    }

    public void setZipCode(String cPostalCode) {
        this.cPostalCode = cPostalCode;
    }

    public void setDialCode(String cDialCode) {
        this.cDialCode = cDialCode;
    }

    public void setNotes(String cNotes) {
        this.cNotes = cNotes;
    }

    public void setUnit(String cUnit) {
        this.cUnit = cUnit;
    }

    public void setCmi(String cmi) {
        this.cmi = cmi;
    }
    
    public void setTaxExempt(boolean isExempt) {
        this.isTaxExempt = isExempt;
    }

    // === OPTIONAL: toString for debugging ===
    @Override
    public String toString() {
        return "LTCCustomer{" +
                "id=" + customerUID +
                ", name='" + getCustomerName() + '\'' +
                ", phone='" + cPhoneNumber + '\'' +
                '}';
    }
}