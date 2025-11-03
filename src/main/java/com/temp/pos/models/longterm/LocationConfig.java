/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temp.pos.models.longterm;

/**
 *
 * @author SatishTandle
 */
public class LocationConfig {
    private int businessFunctionUID;
    private int businessModel;
    private boolean allowPartPay;
    private boolean allowSaveTkt;
    private boolean allowTips;
    private boolean openCashDrawer;
    private boolean exchCouponsAfterTax;
    private boolean vendCouponsAfterTax;
    private int facilityUID;
    private String facilityNumber;
    private int locationUID;
    private String locationName;
    private String storeName;
    private boolean pinReqdForSalesTran;
    private String associateRole;
    private String associateRoleDesc;
    private int contractUID;
    private String contractNumber;
    private String vendorNumber;
    private String vendorName;
    private String facilityName;
    private java.sql.Date contractStart;
    private java.sql.Date contractEnd;
    private String busFuncCode;
    private String assocEmail;
    private boolean isVendorLogin;
    private String sbmUserFirstName;
    private String sbmUserMiddleName;
    private String sbmUserLastName;
    private String sbmUserJobTitle;
    private String sbmUserFullName;
    private String sbmFacilityNumber;
    private String sbmFacilityName;
    private String rgnCode;
    private String countryCode;
    private String currCode;
    private String ccDevice;
    private String regionId;
    private String defaultCurrency;
    private String usdFastcash;
    private String frgnFastcash;
    private String countryDialCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String phoneNumber;
    private String postalCode;
    private Boolean eagleCashOptn;
    private boolean useShipHndlng;

    // Getters and Setters
    public int getBusinessFunctionUID() {
        return businessFunctionUID;
    }

    public void setBusinessFunctionUID(int businessFunctionUID) {
        this.businessFunctionUID = businessFunctionUID;
    }

    public int getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(int businessModel) {
        this.businessModel = businessModel;
    }

    public boolean isAllowPartPay() {
        return allowPartPay;
    }

    public void setAllowPartPay(boolean allowPartPay) {
        this.allowPartPay = allowPartPay;
    }

    public boolean isAllowSaveTkt() {
        return allowSaveTkt;
    }

    public void setAllowSaveTkt(boolean allowSaveTkt) {
        this.allowSaveTkt = allowSaveTkt;
    }

    public boolean isAllowTips() {
        return allowTips;
    }

    public void setAllowTips(boolean allowTips) {
        this.allowTips = allowTips;
    }

    public boolean isOpenCashDrawer() {
        return openCashDrawer;
    }

    public void setOpenCashDrawer(boolean openCashDrawer) {
        this.openCashDrawer = openCashDrawer;
    }

    public boolean isExchCouponsAfterTax() {
        return exchCouponsAfterTax;
    }

    public void setExchCouponsAfterTax(boolean exchCouponsAfterTax) {
        this.exchCouponsAfterTax = exchCouponsAfterTax;
    }

    public boolean isVendCouponsAfterTax() {
        return vendCouponsAfterTax;
    }

    public void setVendCouponsAfterTax(boolean vendCouponsAfterTax) {
        this.vendCouponsAfterTax = vendCouponsAfterTax;
    }

    public int getFacilityUID() {
        return facilityUID;
    }

    public void setFacilityUID(int facilityUID) {
        this.facilityUID = facilityUID;
    }

    public String getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(String facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public int getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(int locationUID) {
        this.locationUID = locationUID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isPinReqdForSalesTran() {
        return pinReqdForSalesTran;
    }

    public void setPinReqdForSalesTran(boolean pinReqdForSalesTran) {
        this.pinReqdForSalesTran = pinReqdForSalesTran;
    }

    public String getAssociateRole() {
        return associateRole;
    }

    public void setAssociateRole(String associateRole) {
        this.associateRole = associateRole;
    }

    public String getAssociateRoleDesc() {
        return associateRoleDesc;
    }

    public void setAssociateRoleDesc(String associateRoleDesc) {
        this.associateRoleDesc = associateRoleDesc;
    }

    public int getContractUID() {
        return contractUID;
    }

    public void setContractUID(int contractUID) {
        this.contractUID = contractUID;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public java.sql.Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(java.sql.Date contractStart) {
        this.contractStart = contractStart;
    }

    public java.sql.Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(java.sql.Date contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getBusFuncCode() {
        return busFuncCode;
    }

    public void setBusFuncCode(String busFuncCode) {
        this.busFuncCode = busFuncCode;
    }

    public String getAssocEmail() {
        return assocEmail;
    }

    public void setAssocEmail(String assocEmail) {
        this.assocEmail = assocEmail;
    }

    public boolean isIsVendorLogin() {
        return isVendorLogin;
    }

    public void setIsVendorLogin(boolean isVendorLogin) {
        this.isVendorLogin = isVendorLogin;
    }

    public String getSbmUserFirstName() {
        return sbmUserFirstName;
    }

    public void setSbmUserFirstName(String sbmUserFirstName) {
        this.sbmUserFirstName = sbmUserFirstName;
    }

    public String getSbmUserMiddleName() {
        return sbmUserMiddleName;
    }

    public void setSbmUserMiddleName(String sbmUserMiddleName) {
        this.sbmUserMiddleName = sbmUserMiddleName;
    }

    public String getSbmUserLastName() {
        return sbmUserLastName;
    }

    public void setSbmUserLastName(String sbmUserLastName) {
        this.sbmUserLastName = sbmUserLastName;
    }

    public String getSbmUserJobTitle() {
        return sbmUserJobTitle;
    }

    public void setSbmUserJobTitle(String sbmUserJobTitle) {
        this.sbmUserJobTitle = sbmUserJobTitle;
    }

    public String getSbmUserFullName() {
        return sbmUserFullName;
    }

    public void setSbmUserFullName(String sbmUserFullName) {
        this.sbmUserFullName = sbmUserFullName;
    }

    public String getSbmFacilityNumber() {
        return sbmFacilityNumber;
    }

    public void setSbmFacilityNumber(String sbmFacilityNumber) {
        this.sbmFacilityNumber = sbmFacilityNumber;
    }

    public String getSbmFacilityName() {
        return sbmFacilityName;
    }

    public void setSbmFacilityName(String sbmFacilityName) {
        this.sbmFacilityName = sbmFacilityName;
    }

    public String getRgnCode() {
        return rgnCode;
    }

    public void setRgnCode(String rgnCode) {
        this.rgnCode = rgnCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getCcDevice() {
        return ccDevice;
    }

    public void setCcDevice(String ccDevice) {
        this.ccDevice = ccDevice;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getUsdFastcash() {
        return usdFastcash;
    }

    public void setUsdFastcash(String usdFastcash) {
        this.usdFastcash = usdFastcash;
    }

    public String getFrgnFastcash() {
        return frgnFastcash;
    }

    public void setFrgnFastcash(String frgnFastcash) {
        this.frgnFastcash = frgnFastcash;
    }

    public String getCountryDialCode() {
        return countryDialCode;
    }

    public void setCountryDialCode(String countryDialCode) {
        this.countryDialCode = countryDialCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean getEagleCashOptn() {
        return eagleCashOptn;
    }

    public void setEagleCashOptn(Boolean eagleCashOptn) {
        this.eagleCashOptn = eagleCashOptn;
    }

    public boolean isUseShipHndlng() {
        return useShipHndlng;
    }

    public void setUseShipHndlng(boolean useShipHndlng) {
        this.useShipHndlng = useShipHndlng;
    }
}
