package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return product;
    }

    @Override
    public Long insertProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }
}
