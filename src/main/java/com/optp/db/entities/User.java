package com.optp.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private String email;
    private boolean userStatus;

    @OneToMany(targetEntity = Address.class, mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;

    @OneToMany(targetEntity = Contact.class, mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contactList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Address> getAddress() {
        return addressList;
    }

    public void setAddress(List<Address> addressList) {
        this.addressList = addressList;
    }
}
