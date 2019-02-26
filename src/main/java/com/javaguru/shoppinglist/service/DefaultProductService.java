package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class DefaultProductService implements ProductService {

    private Long shoppingCartIdSequence = 0L;
//    private ProductRepository database = new ProductRepository();
    private final ProductRepository database;
    private ShoppingCartRepository shoppingCartDatabase = new ShoppingCartRepository();
    private ProductValidationService productValidationService = new ProductValidationService();

    public DefaultProductService(ProductRepository database) {
        this.database = database;
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
        Product createdProduct = database.insertProduct(product);
        return createdProduct.getId();
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
