package com.temp.pos.longterm.models;

import com.temp.pos.longterm.models.Options.LogEventTypes;
import com.temp.pos.models.common.CPOSDB;
import com.temp.pos.models.common.MobileBase;

public class LogMsg extends MobileBase {
    private String id;
    private LogEventTypes type;
    private String message;
    private CPOSDB dbVal;
    private boolean isRoving;

    public LogMsg() {
        isRoving = false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LogEventTypes getType() {
        return type;
    }

    public void setType(LogEventTypes type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CPOSDB getDbVal() {
        return dbVal;
    }

    public void setDbVal(CPOSDB dbVal) {
        this.dbVal = dbVal;
    }

    public boolean isRoving() {
        return isRoving;
    }

    public void setRoving(boolean roving) {
        isRoving = roving;
    }
}