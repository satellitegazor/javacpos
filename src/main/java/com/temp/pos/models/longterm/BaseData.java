package com.temp.pos.models.longterm;

import java.sql.Date;

public class BaseData {
    private int id;
    private String activeInd;
    private Date maintTimestamp;
    private String maintUserId;
    private Date createdTimestamp;
    private String createdUserId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public Date getMaintTimestamp() {
        return maintTimestamp;
    }

    public void setMaintTimestamp(Date maintTimestamp) {
        this.maintTimestamp = maintTimestamp;
    }

    public String getMaintUserId() {
        return maintUserId;
    }

    public void setMaintUserId(String maintUserId) {
        this.maintUserId = maintUserId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }
}