package com.optp.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductSku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productSkuId;
    private int productId;
    private String productSkuCode;
    private float productSkuPrice;
    private boolean productSkuStatus;

    public int getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(int productSkuId) {
        this.productSkuId = productSkuId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public float getProductSkuPrice() {
        return productSkuPrice;
    }

    public void setProductSkuPrice(float productSkuPrice) {
        this.productSkuPrice = productSkuPrice;
    }

    public boolean isProductSkuStatus() {
        return productSkuStatus;
    }

    public void setProductSkuStatus(boolean productSkuStatus) {
        this.productSkuStatus = productSkuStatus;
    }
}
