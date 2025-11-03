package com.temp.pos.models.longterm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LTCAbbrLocationModel {
    private String facilityName;
    private String facilityNumber;
    private String regionId;
    private int locationUID;
    private String exchangeNumber;
    private int contractUID;
    @JsonFormat(pattern = "mm/dd/yyyy HH:mm:ss")
    private Date contractStartDate;
    @JsonFormat(pattern = "mm/dd/yyyy HH:mm:ss")
    private Date contarctEndDate; // Assuming this should be contractEndDate

    // Getter and Setter for facilityName
    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    // Getter and Setter for facilityNumber
    public String getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(String facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    // Getter and Setter for regionId
    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    // Getter and Setter for locationUID
    public int getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(int locationUID) {
        this.locationUID = locationUID;
    }

    // Getter and Setter for exchangeNumber
    public String getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(String exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }

    // Getter and Setter for contractUID
    public int getContractUID() {
        return contractUID;
    }

    public void setContractUID(int contractUID) {
        this.contractUID = contractUID;
    }

    // Getter and Setter for contractStartDate
    
    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    // Getter and Setter for contarctEndDate (should be contractEndDate)
    
    public Date getContarctEndDate() {
        return contarctEndDate;
    }

    public void setContarctEndDate(Date contarctEndDate) {
        this.contarctEndDate = contarctEndDate;
    }
}