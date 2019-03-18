package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.DefaultProductRepository;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {

    private Long shoppingCartIdSequence = 0L;

//    private final ProductInMemoryRepository database;
    private final DefaultProductRepository database;
    private final ProductValidationService productValidationService;
    private final ShoppingCartRepository shoppingCartDatabase;

    @Autowired
//    public DefaultProductService(ProductInMemoryRepository database, ShoppingCartRepository shoppingCartDatabase, ProductValidationService productValidationService) {
    public DefaultProductService(DefaultProductRepository database, ShoppingCartRepository shoppingCartDatabase, ProductValidationService productValidationService) {
        this.database = database;
        this.shoppingCartDatabase = shoppingCartDatabase;
        this.productValidationService = productValidationService;
    }

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
            throw new IllegalArgumentException("Error: Product must be not null!");
        }

        productValidationService.validate(product);
        Long createdProduct = database.insertProduct(product);
        return createdProduct;
    }

    @Override
    public Long createShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            throw new IllegalArgumentException("Error: Shopping Cart must be not null!");
        }

        shoppingCart.setId(shoppingCartIdSequence);
        shoppingCartDatabase.insertShoppingCart(shoppingCartIdSequence, shoppingCart);
        return shoppingCartIdSequence++;
    }

    @Override
    public ShoppingCart findShoppingCartById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: Id must be not null!");
        }
        return shoppingCartDatabase.getShoppingCartById(id);
    }

    @Override
    public void printAllShoppingCarts() {
        shoppingCartDatabase.printAllShoppingCarts();
    }

    @Override
    public void deleteShoppingCartById(Long id) {
        shoppingCartDatabase.deleteShoppingCartById(id);
    }


}
