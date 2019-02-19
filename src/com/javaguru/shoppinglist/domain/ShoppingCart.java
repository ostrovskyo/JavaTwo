package com.javaguru.shoppinglist.domain;

import com.javaguru.shoppinglist.service.TotalPriceCalculation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private Long id;
    private String name;
    private List<Product> productList;

    private TotalPriceCalculation totalPriceCalculation = new TotalPriceCalculation();
    private BigDecimal totalPrice = new BigDecimal(0);

    public void calculateTotalPrice() {
        totalPrice = totalPriceCalculation.getTotalPrice(productList);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(productList, that.productList) &&
                Objects.equals(totalPriceCalculation, that.totalPriceCalculation) &&
                Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productList, totalPriceCalculation, totalPrice);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", productList=" + productList +
                '}';
    }
}
