package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TotalPriceCalculationTest {

    private TotalPriceCalculation victim = new TotalPriceCalculation();
    private List<Product> productList = new ArrayList<>();

    @Test
    public void shouldCalculateTotalPrice() {
        fillProductList();
        BigDecimal expected = new BigDecimal(555);
        BigDecimal actual = victim.getTotalPrice(productList);

        assertEquals(expected, actual);
    }

    private void fillProductList() {
        BigDecimal price;
        BigDecimal discount;
        BigDecimal actualPrice;

        price = new BigDecimal(100);
        discount = new BigDecimal(50);
        actualPrice = new BigDecimal(50);
        productList.add(createProduct(100L, "apple", price, Category.FRESH_PRODUCE, discount, "First product", actualPrice));

        price = new BigDecimal(10);
        discount = new BigDecimal(50);
        actualPrice = new BigDecimal(5);
        productList.add(createProduct(100L, "apple", price, Category.FRESH_PRODUCE, discount, "First product", actualPrice));

        price = new BigDecimal(1000);
        discount = new BigDecimal(500);
        actualPrice = new BigDecimal(500);
        productList.add(createProduct(100L, "apple", price, Category.FRESH_PRODUCE, discount, "First product", actualPrice));
    }

    private Product createProduct(Long id, String name, BigDecimal price, Category category, BigDecimal discount, String description, BigDecimal actualPrice) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);
        product.setActualPrice(actualPrice);
        return product;
    }
}