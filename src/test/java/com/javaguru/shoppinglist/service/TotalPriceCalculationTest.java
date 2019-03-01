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
    public List<Product> productList = new ArrayList<>();

    @Test
    public void shouldCalculateTotalPrice() {
        productList = fillProductList();

        BigDecimal expected = new BigDecimal(555);
        BigDecimal actual = victim.getTotalPrice(productList);

        assertEquals(expected, actual);
    }

    private List<Product> fillProductList() {
        productList.add(createProduct(100L, "apple", new BigDecimal(100), Category.FRESH_PRODUCE, new BigDecimal(50), "First product", new BigDecimal(50)));
        productList.add(createProduct(101L, "apple", new BigDecimal(10), Category.FRESH_PRODUCE, new BigDecimal(50), "First product", new BigDecimal(5)));
        productList.add(createProduct(102L, "apple", new BigDecimal(1000), Category.FRESH_PRODUCE, new BigDecimal(50), "First product", new BigDecimal(500)));
        return productList;
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