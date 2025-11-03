package com.temp.pos.models.shortterm;

import java.util.List;

import com.temp.pos.models.common.FacilityModel;


public class ROV_Facility {
    private int facilityUID;
    private String facilityNumber;
    private int contractUID;
    private String regionUID;
    private int businessFunctionUID;
    private int businessCategoryUID;
    private FacilityModel fmfChargeToFacility;
    private FacilityModel fmfFacility;
    private FacilityModel fmfParentFacility;
    private boolean hasUpdates;
    private List<ROV_Event> events;

    public ROV_Facility() {
        this.hasUpdates = false;
    }

    // Getters and Setters
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

    public int getContractUID() {
        return contractUID;
    }

    public void setContractUID(int contractUID) {
        this.contractUID = contractUID;
    }

    public String getRegionUID() {
        return regionUID;
    }

    public void setRegionUID(String regionUID) {
        this.regionUID = regionUID;
    }

    public int getBusinessFunctionUID() {
        return businessFunctionUID;
    }

    public void setBusinessFunctionUID(int businessFunctionUID) {
        this.businessFunctionUID = businessFunctionUID;
    }

    public int getBusinessCategoryUID() {
        return businessCategoryUID;
    }

    public void setBusinessCategoryUID(int businessCategoryUID) {
        this.businessCategoryUID = businessCategoryUID;
    }

    public FacilityModel getFmfChargeToFacility() {
        return fmfChargeToFacility;
    }

    public void setFmfChargeToFacility(FacilityModel fmfChargeToFacility) {
        this.fmfChargeToFacility = fmfChargeToFacility;
    }

    public FacilityModel getFmfFacility() {
        return fmfFacility;
    }

    public void setFmfFacility(FacilityModel fmfFacility) {
        this.fmfFacility = fmfFacility;
    }

    public FacilityModel getFmfParentFacility() {
        return fmfParentFacility;
    }

    public void setFmfParentFacility(FacilityModel fmfParentFacility) {
        this.fmfParentFacility = fmfParentFacility;
    }

    public boolean isHasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }

    public List<ROV_Event> getEvents() {
        return events;
    }

    public void setEvents(List<ROV_Event> events) {
        this.events = events;
    }
}