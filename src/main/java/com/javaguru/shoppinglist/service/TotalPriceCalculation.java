package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class TotalPriceCalculation {

    public BigDecimal getTotalPrice(List<Product> productList) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Product element : productList) {
            totalPrice = totalPrice.add(element.getActualPrice());
        }
        return totalPrice;
    }
}
