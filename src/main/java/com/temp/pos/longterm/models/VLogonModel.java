package com.temp.pos.longterm.models;

public class VLogonModel {
    private int cliTimeVar;
    private boolean contractType;
    private String exchangeNumber;
    private String facilityName;
    private String facilityNumber;
    private String guid;
    private int individualUID;
    private int locationUID;
    private boolean loggingOut;
    private String newPIN;
    private int pageID;
    private String pin;
    private boolean privActConfmComplete;
    private String regionId;
    private int showPrivPrivTrngConfrm;
    private String vendorNumber;
    private String verifyPIN;

    public VLogonModel() {
        cliTimeVar = 0;
        contractType = false;
        exchangeNumber = "";
        facilityName = "";
        facilityNumber = "";
        guid = "";
        individualUID = 0;
        locationUID = 0;
        loggingOut = false;
        newPIN = "";
        pageID = 0;
        pin = "";
        privActConfmComplete = false;
        regionId = "";
        showPrivPrivTrngConfrm = 0;
        vendorNumber = "";
        verifyPIN = "";
    }

    // Getters and Setters
    public int getCliTimeVar() {
        return cliTimeVar;
    }

    public void setCliTimeVar(int cliTimeVar) {
        this.cliTimeVar = cliTimeVar;
    }

    public boolean isContractType() {
        return contractType;
    }

    public void setContractType(boolean contractType) {
        this.contractType = contractType;
    }

    public String getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(String exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(String facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getIndividualUID() {
        return individualUID;
    }

    public void setIndividualUID(int individualUID) {
        this.individualUID = individualUID;
    }

    public int getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(int locationUID) {
        this.locationUID = locationUID;
    }

    public boolean isLoggingOut() {
        return loggingOut;
    }

    public void setLoggingOut(boolean loggingOut) {
        this.loggingOut = loggingOut;
    }

    public String getNewPIN() {
        return newPIN;
    }

    public void setNewPIN(String newPIN) {
        this.newPIN = newPIN;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isPrivActConfmComplete() {
        return privActConfmComplete;
    }

    public void setPrivActConfmComplete(boolean privActConfmComplete) {
        this.privActConfmComplete = privActConfmComplete;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public int getShowPrivPrivTrngConfrm() {
        return showPrivPrivTrngConfrm;
    }

    public void setShowPrivPrivTrngConfrm(int showPrivPrivTrngConfrm) {
        this.showPrivPrivTrngConfrm = showPrivPrivTrngConfrm;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getVerifyPIN() {
        return verifyPIN;
    }

    public void setVerifyPIN(String verifyPIN) {
        this.verifyPIN = verifyPIN;
    }
}