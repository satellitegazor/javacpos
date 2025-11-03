package com.temp.pos.models.shortterm;

import com.temp.pos.models.common.MobileBase;

public class ROVEventEndStatRsltMdl {
    private MobileBase results;
    private int eventId;
    private boolean eventEnded;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isEventEnded() {
        return eventEnded;
    }

    public void setEventEnded(boolean eventEnded) {
        this.eventEnded = eventEnded;
    }
}