package com.temp.pos.longterm.models;

public class UserPrefModel extends BaseData {
    private String userId;
    private String exchangeFacilityNumber;
    private String exchangeName;
    private String exchangeRegionNumber;
    private String exchangeRegionName;
    private String favoriteLocation;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExchangeFacilityNumber() {
        return exchangeFacilityNumber;
    }

    public void setExchangeFacilityNumber(String exchangeFacilityNumber) {
        this.exchangeFacilityNumber = exchangeFacilityNumber;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeRegionNumber() {
        return exchangeRegionNumber;
    }

    public void setExchangeRegionNumber(String exchangeRegionNumber) {
        this.exchangeRegionNumber = exchangeRegionNumber;
    }

    public String getExchangeRegionName() {
        return exchangeRegionName;
    }

    public void setExchangeRegionName(String exchangeRegionName) {
        this.exchangeRegionName = exchangeRegionName;
    }

    public String getFavoriteLocation() {
        return favoriteLocation;
    }

    public void setFavoriteLocation(String favoriteLocation) {
        this.favoriteLocation = favoriteLocation;
    }
}