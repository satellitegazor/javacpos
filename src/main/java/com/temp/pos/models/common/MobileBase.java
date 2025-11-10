package com.temp.pos.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileBase {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("returnCode")
    private String returnCode;

    @JsonProperty("returnMsg")
    private String returnMsg;

    @JsonProperty("success")
    private boolean success;

    // === GETTERS & SETTERS ===
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getReturnCode() { return returnCode; }
    public void setReturnCode(String returnCode) { this.returnCode = returnCode; }

    public String getReturnMsg() { return returnMsg; }
    public void setReturnMsg(String returnMsg) { this.returnMsg = returnMsg; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}