package com.optp.controllers.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class CityBean {

    private int cityId;

    @NotEmpty
    private String cityName;

    private int cityStatus;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(int cityStatus) {
        this.cityStatus = cityStatus;
    }
}
