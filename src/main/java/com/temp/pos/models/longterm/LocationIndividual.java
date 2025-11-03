/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temp.pos.models.longterm;

/**
 *
 * @author SatishTandle
 */
public class LocationIndividual {
       private int individualUID;
    private String associateName;
    private String emailAddress;
    private int indLocUID;

    // Getters and Setters
    public int getIndividualUID() {
        return individualUID;
    }

    public void setIndividualUID(int individualUID) {
        this.individualUID = individualUID;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getIndLocUID() {
        return indLocUID;
    }

    public void setIndLocUID(int indLocUID) {
        this.indLocUID = indLocUID;
    }
}
