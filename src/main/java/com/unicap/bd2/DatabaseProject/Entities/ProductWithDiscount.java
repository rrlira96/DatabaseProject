package com.unicap.bd2.DatabaseProject.Entities;

public class ProductWithDiscount {

    private int productId;
    private double discount;

    public ProductWithDiscount() {
    }

    public ProductWithDiscount(int productId, double discount) {
        this.productId = productId;
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
