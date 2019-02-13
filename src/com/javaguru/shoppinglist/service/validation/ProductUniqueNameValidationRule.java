package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.Repository;

public class ProductUniqueNameValidationRule implements ProductValidationRule{

    Repository repository = new Repository();

    @Override
    public void validate(Product product) {
        if (repository.getProductByName(product.getName()) != null) {
            throw new IllegalArgumentException("Error: Product with name \"" + product.getName() + "\" already exists!");
        }
    }
}
