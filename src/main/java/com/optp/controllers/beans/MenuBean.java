package com.optp.controllers.beans;

import javax.validation.constraints.NotNull;

public class MenuBean {
    private int menuId;
    @NotNull
    private String menuTitle;
    private int menuSequenceNo;
    private boolean menuStatus;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public int getMenuSequenceNo() {
        return menuSequenceNo;
    }

    public void setMenuSequenceNo(int menuSequenceNo) {
        this.menuSequenceNo = menuSequenceNo;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }
}
