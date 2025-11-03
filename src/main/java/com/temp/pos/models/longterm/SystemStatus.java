package com.temp.pos.models.longterm;

import java.sql.Date;

public class SystemStatus {
    private String priority;
    private String processUp;
    private String expectedUpTime;
    private String reason;
    private Date downTimeStart;
    private Date downTimeEnd;

    // Getters and Setters
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProcessUp() {
        return processUp;
    }

    public void setProcessUp(String processUp) {
        this.processUp = processUp;
    }

    public String getExpectedUpTime() {
        return expectedUpTime;
    }

    public void setExpectedUpTime(String expectedUpTime) {
        this.expectedUpTime = expectedUpTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDownTimeStart() {
        return downTimeStart;
    }

    public void setDownTimeStart(Date downTimeStart) {
        this.downTimeStart = downTimeStart;
    }

    public Date getDownTimeEnd() {
        return downTimeEnd;
    }

    public void setDownTimeEnd(Date downTimeEnd) {
        this.downTimeEnd = downTimeEnd;
    }
}