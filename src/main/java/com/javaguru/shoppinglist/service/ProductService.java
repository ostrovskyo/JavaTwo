package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ProductDto;

public interface ProductService {

    Long create(ProductDto productDto);

    Product findById(Long id);

    Long createShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart findShoppingCartById(Long id);

    void printAllShoppingCarts();

    void printAllProducts();

    void deleteShoppingCartById(Long id);
}
