package com.temp.pos.models.common;

import java.sql.Date;

public class CPOSPinPadLogStatus {
    private int logCount;
    private int locationEventId;
    private Date maintTimeStamp;

    // Getters and Setters
    public int getLogCount() {
        return logCount;
    }

    public void setLogCount(int logCount) {
        this.logCount = logCount;
    }

    public int getLocationEventId() {
        return locationEventId;
    }

    public void setLocationEventId(int locationEventId) {
        this.locationEventId = locationEventId;
    }

    public Date getMaintTimeStamp() {
        return maintTimeStamp;
    }

    public void setMaintTimeStamp(Date maintTimeStamp) {
        this.maintTimeStamp = maintTimeStamp;
    }
}