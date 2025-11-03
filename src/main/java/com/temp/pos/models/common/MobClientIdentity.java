package com.temp.pos.models.common;

public class MobClientIdentity {
    public static String NON_AAFES_PERSONNEL_CODES = "CIMO";

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
    private String userId;
    private String principalCacheKey;
    private boolean isLnUser;
    private boolean isNonAafes;
    private boolean isAuthenticated;

    // Getters and Setters
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        isLnUser = lnUser;
    }

    public boolean isNonAafes() {
        return isNonAafes;
    }

    public void setNonAafes(boolean nonAafes) {
        isNonAafes = nonAafes;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }
}