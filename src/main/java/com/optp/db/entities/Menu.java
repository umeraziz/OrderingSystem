package com.optp.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

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

    public void setMenuTitle(String menuName) {
        this.menuTitle = menuName;
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
