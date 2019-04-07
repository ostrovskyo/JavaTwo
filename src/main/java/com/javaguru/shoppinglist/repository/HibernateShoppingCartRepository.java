package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateShoppingCartRepository implements ShoppingCartRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long insertShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getId();
    }

    @Override
    public void printAllShoppingCarts() {
        Query query = sessionFactory.getCurrentSession().createQuery("from ShoppingCart");
        List<ShoppingCart> list = query.list();

        for (ShoppingCart element : list) {
            System.out.println(element);
        }
    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return shoppingCart;
    }

    @Override
    public void deleteShoppingCartById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.load(ShoppingCart.class, id);
        session.delete(shoppingCart);

        session.flush();
    }
}
