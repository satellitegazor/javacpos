package com.temp.pos.models.shortterm;

public class ROVDepartment {
    private boolean hasUpdates;
    private int eventUID;

    // Getters and Setters
    public boolean isHasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }

    public int getEventUID() {
        return eventUID;
    }

    public void setEventUID(int eventUID) {
        this.eventUID = eventUID;
    }
}