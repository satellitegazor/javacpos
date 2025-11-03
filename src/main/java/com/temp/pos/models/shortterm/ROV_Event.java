package com.temp.pos.models.shortterm;

import java.util.List;

public class ROV_Event {
    private int eventID;
    private List<ROVDepartment> departments;
    private List<ROVIndividual> associates;

    // Getters and Setters
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public List<ROVDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<ROVDepartment> departments) {
        this.departments = departments;
    }

    public List<ROVIndividual> getAssociates() {
        return associates;
    }

    public void setAssociates(List<ROVIndividual> associates) {
        this.associates = associates;
    }
}