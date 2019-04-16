package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product getProductById(Long id);

    Long insertProduct(Product product);

    Optional<Product> getProductByName(String name);

    List<Product> getAllProducts();
}
