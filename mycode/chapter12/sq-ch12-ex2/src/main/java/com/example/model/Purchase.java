package com.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id == purchase.getId() && Objects.equals(product, purchase.getProduct()) &&
                Objects.equals(price, purchase.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price);
    }
}
