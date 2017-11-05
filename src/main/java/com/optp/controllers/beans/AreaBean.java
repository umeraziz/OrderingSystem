package com.optp.controllers.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class AreaBean {

    private int areaId;

    @NotEmpty
    private String areaName;

    private int areaStatus;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(int areaStatus) {
        this.areaStatus = areaStatus;
    }
}
