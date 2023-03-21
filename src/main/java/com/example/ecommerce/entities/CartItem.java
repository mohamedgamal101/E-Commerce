package com.example.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long customerId;
    @Column(nullable = false)
    private double totalUnoitsPrice;
    @Column(nullable = false)
    private int unitsCount;
    @Column(nullable = false)
    private double vat;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getTotalUnoitsPrice() {
        return totalUnoitsPrice;
    }

    public void setTotalUnoitsPrice(double totalUnoitsPrice) {
        this.totalUnoitsPrice = totalUnoitsPrice;
    }

    public int getUnitsCount() {
        return unitsCount;
    }

    public void setUnitsCount(int unitsCount) {
        this.unitsCount = unitsCount;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
