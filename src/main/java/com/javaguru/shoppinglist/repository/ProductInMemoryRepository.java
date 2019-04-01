package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemorydb")
public class ProductInMemoryRepository implements ProductRepository{

    private Long productIdSequence = 0L;

    private static final Map<Long, Product> database = new HashMap<>();

    public Product getProductById(Long id) {
        return database.get(id);
    }

    public Long insertProduct(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        productIdSequence++;
        return product.getId();
    }

    public Optional<Product> getProductByName(String name) {
        for (Product element : database.values()) {
            if (element.getName().equals(name)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    public void showAllProducts() {
        for (Product element : database.values()) {
            System.out.println(element);
        }
    }
}
