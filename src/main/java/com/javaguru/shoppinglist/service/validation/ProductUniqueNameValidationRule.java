package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.Optional;

public class ProductUniqueNameValidationRule implements ProductValidationRule{

    private final ProductRepository database;

    public ProductUniqueNameValidationRule(ProductRepository database) {
        this.database = database;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (!database.getProductByName(product.getName()).equals(Optional.empty())) {
            throw new IllegalArgumentException("Error: Product with name \"" + product.getName() + "\" already exists!");
        }
    }
}
