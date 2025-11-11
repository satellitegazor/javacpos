/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temp.pos.longterm.models;

/**
 *
 * @author SatishTandle
 */
public class LTCHoursOfOperation {
    
    private int hrsOfOperationID;
    private int locationUID;
    private String dayFrom;
    private String dayTo;
    private String timeFrom;
    private String timeTo;
    private String displayOrder;
    private boolean hasUpdates;

    // Getters and Setters
    public int getHrsOfOperationID() {
        return hrsOfOperationID;
    }

    public void setHrsOfOperationID(int hrsOfOperationID) {
        this.hrsOfOperationID = hrsOfOperationID;
    }

    public int getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(int locationUID) {
        this.locationUID = locationUID;
    }

    public String getDayFrom() {
        return dayFrom;
    }

    public void setDayFrom(String dayFrom) {
        this.dayFrom = dayFrom;
    }

    public String getDayTo() {
        return dayTo;
    }

    public void setDayTo(String dayTo) {
        this.dayTo = dayTo;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public boolean isHasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }
}
