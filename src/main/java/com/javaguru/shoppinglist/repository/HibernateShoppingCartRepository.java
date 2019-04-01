package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateShoppingCartRepository implements ShoppingCartRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Map<Long, ShoppingCart> database = new HashMap<>();

//    @Override
//    public Long insertShoppingCart(ShoppingCart shoppingCart) {
//        sessionFactory.getCurrentSession().save(shoppingCart);
//        return shoppingCart.getId();
//    }

    @Override
    public Long insertShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getId();
    }

    @Override
    public void printAllShoppingCarts() {

    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return null;
    }

    @Override
    public void deleteShoppingCartById(Long id) {

    }
//
//    public void insertShoppingCart(Long id, ShoppingCart shoppingCart) {
//        database.put(id, shoppingCart);
//    }
//
//    public void printAllShoppingCarts() {
//        for (ShoppingCart element : database.values()) {
//            System.out.println(element);
//        }
//    }
//
//    public ShoppingCart getShoppingCartById(Long id) {
//        return database.get(id);
//    }
//
//    public void deleteShoppingCartById(Long id) {
//        database.remove(id);
//    }
}
