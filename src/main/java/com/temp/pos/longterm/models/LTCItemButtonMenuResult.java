package com.temp.pos.longterm.models;


public class LTCItemButtonMenuResult {
    // Placeholder for fields, as not defined in provided code
      private int locationUID;
    private String locationName;
    private int businessFunctionUID;
    private String businessFunctionDescription;
    private String businessModel;
    private String departmentName;
    private String contractUID;
    private String facilityNumber;
    private int facilityUID;
    private int departmentUID;
    private int salesCategoryID;
    private String salesCategoryDescription;
    private int salesItemID;
    private String salesItemDescription;
    private int displayOrder;
    private int displayOrderItem;
    private double price;
    private double salesTax;
    private double envTax;
    private Boolean allowTaxExemption;
    private Boolean exchCouponsAfterTax;
    private Boolean vendCouponsAfterTax;
    private int noOfTags;
    private double feePercent;
    private Boolean allowTags;
    private Boolean allowEnvTax;
    private Boolean custInfoReq;
    private int defaultNoOfTags;
    private Boolean allowPartPay;
    private Boolean allowSaveTkt;
    private Boolean allowTips;
    private Boolean openCashDrwForTips;
    private java.sql.Date maintTimestamp;
    private java.sql.Date salesCatMaintTimeStamp;
    private java.sql.Date deptMaintTimeStamp;
    private java.sql.Date facMaintTimeStamp;
    private Boolean saleItemActive;
    private Boolean salesCatActive;
    private Boolean deptActive;
    private Boolean facActive;
    private String defaultCurrency;
    private String currencyCode;
    private String currencyDesc;
    private int salesCatTypeUID;

    // Getters and Setters
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

    public int getBusinessFunctionUID() {
        return businessFunctionUID;
    }

    public void setBusinessFunctionUID(int businessFunctionUID) {
        this.businessFunctionUID = businessFunctionUID;
    }

    public String getBusinessFunctionDescription() {
        return businessFunctionDescription;
    }

    public void setBusinessFunctionDescription(String businessFunctionDescription) {
        this.businessFunctionDescription = businessFunctionDescription;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getContractUID() {
        return contractUID;
    }

    public void setContractUID(String contractUID) {
        this.contractUID = contractUID;
    }

    public String getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(String facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public int getFacilityUID() {
        return facilityUID;
    }

    public void setFacilityUID(int facilityUID) {
        this.facilityUID = facilityUID;
    }

    public int getDepartmentUID() {
        return departmentUID;
    }

    public void setDepartmentUID(int departmentUID) {
        this.departmentUID = departmentUID;
    }

    public int getSalesCategoryID() {
        return salesCategoryID;
    }

    public void setSalesCategoryID(int salesCategoryID) {
        this.salesCategoryID = salesCategoryID;
    }

    public String getSalesCategoryDescription() {
        return salesCategoryDescription;
    }

    public void setSalesCategoryDescription(String salesCategoryDescription) {
        this.salesCategoryDescription = salesCategoryDescription;
    }

    public int getSalesItemID() {
        return salesItemID;
    }

    public void setSalesItemID(int salesItemID) {
        this.salesItemID = salesItemID;
    }

    public String getSalesItemDescription() {
        return salesItemDescription;
    }

    public void setSalesItemDescription(String salesItemDescription) {
        this.salesItemDescription = salesItemDescription;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getDisplayOrderItem() {
        return displayOrderItem;
    }

    public void setDisplayOrderItem(int displayOrderItem) {
        this.displayOrderItem = displayOrderItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getEnvTax() {
        return envTax;
    }

    public void setEnvTax(double envTax) {
        this.envTax = envTax;
    }

    public Boolean getAllowTaxExemption() {
        return allowTaxExemption;
    }

    public void setAllowTaxExemption(Boolean allowTaxExemption) {
        this.allowTaxExemption = allowTaxExemption;
    }

    public Boolean getExchCouponsAfterTax() {
        return exchCouponsAfterTax;
    }

    public void setExchCouponsAfterTax(Boolean exchCouponsAfterTax) {
        this.exchCouponsAfterTax = exchCouponsAfterTax;
    }

    public Boolean getVendCouponsAfterTax() {
        return vendCouponsAfterTax;
    }

    public void setVendCouponsAfterTax(Boolean vendCouponsAfterTax) {
        this.vendCouponsAfterTax = vendCouponsAfterTax;
    }

    public int getNoOfTags() {
        return noOfTags;
    }

    public void setNoOfTags(int noOfTags) {
        this.noOfTags = noOfTags;
    }

    public double getFeePercent() {
        return feePercent;
    }

    public void setFeePercent(double feePercent) {
        this.feePercent = feePercent;
    }

    public Boolean getAllowTags() {
        return allowTags;
    }

    public void setAllowTags(Boolean allowTags) {
        this.allowTags = allowTags;
    }

    public Boolean getAllowEnvTax() {
        return allowEnvTax;
    }

    public void setAllowEnvTax(Boolean allowEnvTax) {
        this.allowEnvTax = allowEnvTax;
    }

    public Boolean getCustInfoReq() {
        return custInfoReq;
    }

    public void setCustInfoReq(Boolean custInfoReq) {
        this.custInfoReq = custInfoReq;
    }

    public int getDefaultNoOfTags() {
        return defaultNoOfTags;
    }

    public void setDefaultNoOfTags(int defaultNoOfTags) {
        this.defaultNoOfTags = defaultNoOfTags;
    }

    public Boolean getAllowPartPay() {
        return allowPartPay;
    }

    public void setAllowPartPay(Boolean allowPartPay) {
        this.allowPartPay = allowPartPay;
    }

    public Boolean getAllowSaveTkt() {
        return allowSaveTkt;
    }

    public void setAllowSaveTkt(Boolean allowSaveTkt) {
        this.allowSaveTkt = allowSaveTkt;
    }

    public Boolean getAllowTips() {
        return allowTips;
    }

    public void setAllowTips(Boolean allowTips) {
        this.allowTips = allowTips;
    }

    public Boolean getOpenCashDrwForTips() {
        return openCashDrwForTips;
    }

    public void setOpenCashDrwForTips(Boolean openCashDrwForTips) {
        this.openCashDrwForTips = openCashDrwForTips;
    }

    public java.sql.Date getMaintTimestamp() {
        return maintTimestamp;
    }

    public void setMaintTimestamp(java.sql.Date maintTimestamp) {
        this.maintTimestamp = maintTimestamp;
    }

    public java.sql.Date getSalesCatMaintTimeStamp() {
        return salesCatMaintTimeStamp;
    }

    public void setSalesCatMaintTimeStamp(java.sql.Date salesCatMaintTimeStamp) {
        this.salesCatMaintTimeStamp = salesCatMaintTimeStamp;
    }

    public java.sql.Date getDeptMaintTimeStamp() {
        return deptMaintTimeStamp;
    }

    public void setDeptMaintTimeStamp(java.sql.Date deptMaintTimeStamp) {
        this.deptMaintTimeStamp = deptMaintTimeStamp;
    }

    public java.sql.Date getFacMaintTimeStamp() {
        return facMaintTimeStamp;
    }

    public void setFacMaintTimeStamp(java.sql.Date facMaintTimeStamp) {
        this.facMaintTimeStamp = facMaintTimeStamp;
    }

    public Boolean getSaleItemActive() {
        return saleItemActive;
    }

    public void setSaleItemActive(Boolean saleItemActive) {
        this.saleItemActive = saleItemActive;
    }

    public Boolean getSalesCatActive() {
        return salesCatActive;
    }

    public void setSalesCatActive(Boolean salesCatActive) {
        this.salesCatActive = salesCatActive;
    }

    public Boolean getDeptActive() {
        return deptActive;
    }

    public void setDeptActive(Boolean deptActive) {
        this.deptActive = deptActive;
    }

    public Boolean getFacActive() {
        return facActive;
    }

    public void setFacActive(Boolean facActive) {
        this.facActive = facActive;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public int getSalesCatTypeUID() {
        return salesCatTypeUID;
    }

    public void setSalesCatTypeUID(int salesCatTypeUID) {
        this.salesCatTypeUID = salesCatTypeUID;
    }
}