package com.temp.pos.models.common;

public class CPOSPinPadLog {
    private int locationEventId;
    private String facilityNum;
    private int appType;
    private int cliTimeVar;
    private String logData;
    private int userId;
    private int regionId;
    private CPOSDB dbVal;

    // Getters and Setters
    public int getLocationEventId() {
        return locationEventId;
    }

    public void setLocationEventId(int locationEventId) {
        this.locationEventId = locationEventId;
    }

    public String getFacilityNum() {
        return facilityNum;
    }

    public void setFacilityNum(String facilityNum) {
        this.facilityNum = facilityNum;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getCliTimeVar() {
        return cliTimeVar;
    }

    public void setCliTimeVar(int cliTimeVar) {
        this.cliTimeVar = cliTimeVar;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public CPOSDB getDbVal() {
        return dbVal;
    }

    public void setDbVal(CPOSDB dbVal) {
        this.dbVal = dbVal;
    }
}