package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.Repository;
import com.javaguru.shoppinglist.service.validation.ValidationService;

public class DefaultProductService implements ProductService {

    private Long productIdSequence = 0L;
    private Repository database = new Repository();
    private ValidationService validationService = new ValidationService();

    @Override
    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: Id must be not null!");
        }
        return database.getProductById(id);
    }

    @Override
    public Long create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Error: Cannot be null!");
        }

        validationService.validate(product);
        product.setId(productIdSequence);

        database.insertProduct(productIdSequence, product);
        return productIdSequence++;
    }

}
