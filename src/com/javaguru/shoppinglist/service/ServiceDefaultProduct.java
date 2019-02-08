package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.InMemoryDatabase;

public class ServiceDefaultProduct implements ServiceProduct {

    private Long PRODUCT_ID_SEQUENCE = 0L;
    private InMemoryDatabase database = new InMemoryDatabase();

    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.getProductById(id);
    }

    @Override
    public Long create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        product.setId(PRODUCT_ID_SEQUENCE);

        database.insertProduct(PRODUCT_ID_SEQUENCE, product);
        return PRODUCT_ID_SEQUENCE++;
    }

}
