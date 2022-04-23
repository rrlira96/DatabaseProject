package com.unicap.bd2.DatabaseProject.Entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Order Details")
public class OrderDetail implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "OrderId")
    private Order order;

    @Id
    @OneToMany
    @JoinColumn(name = "ProductId")
    private List<Product> products;

    @NonNull
    @Column(name = "UnitPrice")
    private double unitPrice;

    @NonNull
    @Column(name = "Quantity")
    private int quantity;

    @NonNull
    @Column(name = "Discount")
    private double discount;


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Double.compare(that.unitPrice, unitPrice) == 0 && quantity == that.quantity && Double.compare(that.discount, discount) == 0 && order.equals(that.order) && products.equals(that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, products, unitPrice, quantity, discount);
    }
}
