package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    public Product getProductById(Long id);

    public Long insertProduct(Product product);

    public Optional<Product> getProductByName(String name);

    public void showAllProducts();
}
