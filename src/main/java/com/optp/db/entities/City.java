package com.optp.db.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    private String cityName;

    @OneToMany(targetEntity = Address.class, mappedBy = "cityId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressLIst;

    private boolean cityStatus;

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

    public List<Address> getAddressLIst() {
        return addressLIst;
    }

    public void setAddressLIst(List<Address> addressLIst) {
        this.addressLIst = addressLIst;
    }

    public boolean getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(boolean cityStatus) {
        this.cityStatus = cityStatus;
    }
}
