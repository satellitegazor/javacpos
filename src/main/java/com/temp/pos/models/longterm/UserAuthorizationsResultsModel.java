package com.temp.pos.models.longterm;

import com.temp.pos.models.common.MobClientIdentity;
import com.temp.pos.models.common.MobileBase;

public class UserAuthorizationsResultsModel {
    private MobileBase results;
    private MobClientIdentity userIdentity;
    private String[] userRoles;
    private String posTerminalId;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public MobClientIdentity getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(MobClientIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }

    public String getPosTerminalId() {
        return posTerminalId;
    }

    public void setPosTerminalId(String posTerminalId) {
        this.posTerminalId = posTerminalId;
    }
}