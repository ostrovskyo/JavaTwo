package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

public class ProductUniqueNameValidationRule implements ProductValidationRule{

    ProductRepository repository = new ProductRepository();

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (repository.getProductByName(product.getName()) != null) {
            throw new IllegalArgumentException("Error: Product with name \"" + product.getName() + "\" already exists!");
        }
    }
}
