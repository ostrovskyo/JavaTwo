package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.service.validation.ValidationService;

public class DefaultProductService implements ProductService {

    private Long productIdSequence = 0L;
    private Long shoppingCartIdSequence = 0L;
    private ProductRepository database = new ProductRepository();
    private ShoppingCartRepository shoppingCartDatabase = new ShoppingCartRepository();
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

    @Override
    public Long createShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            throw new IllegalArgumentException("Error: Cannot be null!");
        }

        shoppingCart.setId(shoppingCartIdSequence);
        shoppingCartDatabase.insertShoppingCart(shoppingCartIdSequence, shoppingCart);
        return shoppingCartIdSequence++;
    }

    @Override
    public ShoppingCart selectShoppingCart(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: Id must be not null!");
        }
        return shoppingCartDatabase.;
    }
}
