package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductShoppingCart;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.HibernateShoppingCartRepository;
import com.javaguru.shoppinglist.repository.ProductShoppingCartRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartProductService {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ProductShoppingCartRepository productShoppingCartRepository;

    @Autowired
    public ShoppingCartProductService(ProductService productService,
                                      ShoppingCartService shoppingCartService,
                                      ProductShoppingCartRepository productShoppingCartRepository) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.productShoppingCartRepository = productShoppingCartRepository;
    }

    public Long addProductToShoppingCart(Long productId, Long shoppingCartId) {
        Product product = productService.findById(productId);
        ShoppingCart shoppingCart = shoppingCartService.findById(shoppingCartId);

        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setProduct(product);
        productShoppingCart.setShoppingCart(shoppingCart);

        return productShoppingCartRepository.save(productShoppingCart);
    }
}
