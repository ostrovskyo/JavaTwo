package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Long insertProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public void showAllProducts() {

    }
}
