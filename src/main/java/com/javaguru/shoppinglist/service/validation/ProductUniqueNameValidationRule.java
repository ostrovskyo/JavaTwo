package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ProductRepository database;

    @Autowired
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
