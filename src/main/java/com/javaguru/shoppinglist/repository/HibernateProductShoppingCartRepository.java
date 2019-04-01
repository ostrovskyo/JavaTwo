package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class HibernateProductShoppingCartRepository implements ProductShoppingCartRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(ProductShoppingCart productShoppingCart) {
        sessionFactory.getCurrentSession().save(productShoppingCart);
        return productShoppingCart.getId();
    }
}
