package com.temp.pos.longterm.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.List;

public class VendorLoginResultsModel {

    public Results results;
    public int associatePINCount;
    public int resetPIN;
    public int contractUID;
    public String contractNumber;
    public Date contractStart;
    public UserIdentity userIdentity;
    public List<String> userRoles;
    public String associateRole;
    public String associateRoleDesc;
    public String associateName;
    public String locationUID;
    public int eventId;
    public String eventName;
    public String facilityNumber;
    public String facilityName;
    public int individualUID;
    public boolean isAuthorized;
    public int showPrivTrngConfrm;
    public int cliTimeVar;
    public int pageID;
    public Date eventStart;
    public Date eventEnd;
    public String busFuncCode;
    public int busModel;
    public boolean eventEnded;
    public String emailAddr;
    public boolean privActConfmComplete;
    public String regionId;
    public String rgnCode;
    public String countryCode;
    public String currCode;
    public String ccDevice;
    public String usdFastcash;
    public String frgnFastcash;
    public boolean uuidExists;
    public String eagleCashOptn;
    public boolean useShipHndlng;
    public String tokenString;

    // Nested Results class
    public static class Results {
        private String userId;
        private String returnCode;
        private String returnMsg;
        private boolean success;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    // Nested UserIdentity class
    public static class UserIdentity {
        private String name;
        private int employeeID;
        private String firstName;
        private String middleInitial;
        private String lastName;
        private String suffix;
        private String fullName;
        private String employeeTitle;
        private String emailAddress;
        private String personnelCategoryCode;
        private String jobTitle;
        private String dutyFacilityNumber;
        private String dutyFacilityName;
        @JsonProperty("useR_ID")
        private String useR_ID;
        private String principalCacheKey;
        private boolean isLnUser;
        private boolean isNonAafes;
        private boolean isAuthenticated;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleInitial() {
            return middleInitial;
        }

        public void setMiddleInitial(String middleInitial) {
            this.middleInitial = middleInitial;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmployeeTitle() {
            return employeeTitle;
        }

        public void setEmployeeTitle(String employeeTitle) {
            this.employeeTitle = employeeTitle;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getPersonnelCategoryCode() {
            return personnelCategoryCode;
        }

        public void setPersonnelCategoryCode(String personnelCategoryCode) {
            this.personnelCategoryCode = personnelCategoryCode;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getDutyFacilityNumber() {
            return dutyFacilityNumber;
        }

        public void setDutyFacilityNumber(String dutyFacilityNumber) {
            this.dutyFacilityNumber = dutyFacilityNumber;
        }

        public String getDutyFacilityName() {
            return dutyFacilityName;
        }

        public void setDutyFacilityName(String dutyFacilityName) {
            this.dutyFacilityName = dutyFacilityName;
        }

        public String getUseR_ID() {
            return useR_ID;
        }

        public void setUseR_ID(String useR_ID) {
            this.useR_ID = useR_ID;
        }

        public String getPrincipalCacheKey() {
            return principalCacheKey;
        }

        public void setPrincipalCacheKey(String principalCacheKey) {
            this.principalCacheKey = principalCacheKey;
        }

        public boolean isLnUser() {
            return isLnUser;
        }

        public void setLnUser(boolean lnUser) {
            this.isLnUser = lnUser;
        }

        public boolean isNonAafes() {
            return isNonAafes;
        }

        public void setNonAafes(boolean nonAafes) {
            this.isNonAafes = nonAafes;
        }

        public boolean isAuthenticated() {
            return isAuthenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.isAuthenticated = authenticated;
        }
    }

    // Getters and Setters for VendorLoginResultsModel
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public int getAssociatePINCount() {
        return associatePINCount;
    }

    public void setAssociatePINCount(int associatePINCount) {
        this.associatePINCount = associatePINCount;
    }

    public int getResetPIN() {
        return resetPIN;
    }

    public void setResetPIN(int resetPIN) {
        this.resetPIN = resetPIN;
    }

    public int getContractUID() {
        return contractUID;
    }

    public void setContractUID(int contractUID) {
        this.contractUID = contractUID;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    public String getAssociateRole() {
        return associateRole;
    }

    public void setAssociateRole(String associateRole) {
        this.associateRole = associateRole;
    }

    public String getAssociateRoleDesc() {
        return associateRoleDesc;
    }

    public void setAssociateRoleDesc(String associateRoleDesc) {
        this.associateRoleDesc = associateRoleDesc;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getLocationUID() {
        return locationUID;
    }

    public void setLocationUID(String locationUID) {
        this.locationUID = locationUID;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(String facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getIndividualUID() {
        return individualUID;
    }

    public void setIndividualUID(int individualUID) {
        this.individualUID = individualUID;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        this.isAuthorized = authorized;
    }

    public int getShowPrivTrngConfrm() {
        return showPrivTrngConfrm;
    }

    public void setShowPrivTrngConfrm(int showPrivTrngConfrm) {
        this.showPrivTrngConfrm = showPrivTrngConfrm;
    }

    public int getCliTimeVar() {
        return cliTimeVar;
    }

    public void setCliTimeVar(int cliTimeVar) {
        this.cliTimeVar = cliTimeVar;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventStart(Date eventStart) {
        this.eventStart = eventStart;
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Date eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getBusFuncCode() {
        return busFuncCode;
    }

    public void setBusFuncCode(String busFuncCode) {
        this.busFuncCode = busFuncCode;
    }

    public int getBusModel() {
        return busModel;
    }

    public void setBusModel(int busModel) {
        this.busModel = busModel;
    }

    public boolean isEventEnded() {
        return eventEnded;
    }

    public void setEventEnded(boolean eventEnded) {
        this.eventEnded = eventEnded;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public boolean isPrivActConfmComplete() {
        return privActConfmComplete;
    }

    public void setPrivActConfmComplete(boolean privActConfmComplete) {
        this.privActConfmComplete = privActConfmComplete;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRgnCode() {
        return rgnCode;
    }

    public void setRgnCode(String rgnCode) {
        this.rgnCode = rgnCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getCcDevice() {
        return ccDevice;
    }

    public void setCcDevice(String ccDevice) {
        this.ccDevice = ccDevice;
    }

    public String getUsdFastcash() {
        return usdFastcash;
    }

    public void setUsdFastcash(String usdFastcash) {
        this.usdFastcash = usdFastcash;
    }

    public String getFrgnFastcash() {
        return frgnFastcash;
    }

    public void setFrgnFastcash(String frgnFastcash) {
        this.frgnFastcash = frgnFastcash;
    }

    public boolean isUuidExists() {
        return uuidExists;
    }

    public void setUuidExists(boolean uuidExists) {
        this.uuidExists = uuidExists;
    }

    public String getEagleCashOptn() {
        return eagleCashOptn;
    }

    public void setEagleCashOptn(String eagleCashOptn) {
        this.eagleCashOptn = eagleCashOptn;
    }

    public boolean isUseShipHndlng() {
        return useShipHndlng;
    }

    public void setUseShipHndlng(boolean useShipHndlng) {
        this.useShipHndlng = useShipHndlng;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }
}