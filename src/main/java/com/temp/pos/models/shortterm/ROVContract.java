package com.temp.pos.models.shortterm;

import java.sql.Date;

import com.temp.pos.longterm.models.Vendor;
import com.temp.pos.models.common.CPOSRegionCountryCurrencyResultsModel;

public class ROVContract {
    private int contractUID;
    private Date contractStart;
    private Date contractEnd;
    private String contractNumber;
    private String vendorNumber;
    private String regionCode;
    private String regionDesc;
    private String countryCode;
    private String countryName;
    private String currencyCode;
    private String currencyDesc;
    private double milStarTxnFee;
    private Date confirmContractTimestamp;
    private boolean allowTaxExemption;
    private boolean applyCouponsAfterTax;
    private String ownerUID;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmail;
    private String ownerPhone;
    private String ownerCountryDialCode;
    private Vendor concessionaire;
    private boolean vendorEPaid;
    private String chargeToFaciltyNbr;
    private ROV_Facility facility;
    private CPOSRegionCountryCurrencyResultsModel regionCountryCurrency;
    private boolean hasRemoved;
    private boolean hasUpdates;
    private boolean isMerged;
    private int cliTimeVar;
    private int cntrctTranCount;

    public ROVContract() {
        hasUpdates = false;
    }

    // Getters and Setters
    public int getContractUID() {
        return contractUID;
    }

    public void setContractUID(int contractUID) {
        this.contractUID = contractUID;
    }

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionDesc() {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc) {
        this.regionDesc = regionDesc;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public double getMilStarTxnFee() {
        return milStarTxnFee;
    }

    public void setMilStarTxnFee(double milStarTxnFee) {
        this.milStarTxnFee = milStarTxnFee;
    }

    public Date getConfirmContractTimestamp() {
        return confirmContractTimestamp;
    }

    public void setConfirmContractTimestamp(Date confirmContractTimestamp) {
        this.confirmContractTimestamp = confirmContractTimestamp;
    }

    public boolean isAllowTaxExemption() {
        return allowTaxExemption;
    }

    public void setAllowTaxExemption(boolean allowTaxExemption) {
        this.allowTaxExemption = allowTaxExemption;
    }

    public boolean isApplyCouponsAfterTax() {
        return applyCouponsAfterTax;
    }

    public void setApplyCouponsAfterTax(boolean applyCouponsAfterTax) {
        this.applyCouponsAfterTax = applyCouponsAfterTax;
    }

    public String getOwnerUID() {
        return ownerUID;
    }

    public void setOwnerUID(String ownerUID) {
        this.ownerUID = ownerUID;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerCountryDialCode() {
        return ownerCountryDialCode;
    }

    public void setOwnerCountryDialCode(String ownerCountryDialCode) {
        this.ownerCountryDialCode = ownerCountryDialCode;
    }

    public Vendor getConcessionaire() {
        return concessionaire;
    }

    public void setConcessionaire(Vendor concessionaire) {
        this.concessionaire = concessionaire;
    }

    public boolean isVendorEPaid() {
        return vendorEPaid;
    }

    public void setVendorEPaid(boolean vendorEPaid) {
        this.vendorEPaid = vendorEPaid;
    }

    public String getChargeToFaciltyNbr() {
        return chargeToFaciltyNbr;
    }

    public void setChargeToFaciltyNbr(String chargeToFaciltyNbr) {
        this.chargeToFaciltyNbr = chargeToFaciltyNbr;
    }

    public ROV_Facility getFacility() {
        return facility;
    }

    public void setFacility(ROV_Facility facility) {
        this.facility = facility;
    }

    public CPOSRegionCountryCurrencyResultsModel getRegionCountryCurrency() {
        return regionCountryCurrency;
    }

    public void setRegionCountryCurrency(CPOSRegionCountryCurrencyResultsModel regionCountryCurrency) {
        this.regionCountryCurrency = regionCountryCurrency;
    }

    public boolean isHasRemoved() {
        return hasRemoved;
    }

    public void setHasRemoved(boolean hasRemoved) {
        this.hasRemoved = hasRemoved;
    }

    public boolean isHasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }

    public boolean isMerged() {
        return isMerged;
    }

    public void setMerged(boolean merged) {
        isMerged = merged;
    }

    public int getCliTimeVar() {
        return cliTimeVar;
    }

    public void setCliTimeVar(int cliTimeVar) {
        this.cliTimeVar = cliTimeVar;
    }

    public int getCntrctTranCount() {
        return cntrctTranCount;
    }

    public void setCntrctTranCount(int cntrctTranCount) {
        this.cntrctTranCount = cntrctTranCount;
    }

    public void refreshUIDs() {
        // Implementation as per C# code, assuming Facility and Events are defined
        if (facility != null && facility.getEvents() != null) {
            for (ROV_Event ev : facility.getEvents()) {
                if (ev.getDepartments() != null) {
                    for (ROVDepartment dep : ev.getDepartments()) {
                        dep.setHasUpdates(!dep.isHasUpdates() ? (dep.getEventUID() != ev.getEventID() || ev.getEventID() < 0) : true);
                        dep.setEventUID(ev.getEventID());
                    }
                }
                if (ev.getAssociates() != null) {
                    for (ROVIndividual va : ev.getAssociates()) {
                        va.setHasUpdates(!va.isHasUpdates() ? (va.getEventUID() != ev.getEventID() || ev.getEventID() < 0) : true);
                        va.setEventUID(ev.getEventID());
                    }
                }
            }
        }
    }
}