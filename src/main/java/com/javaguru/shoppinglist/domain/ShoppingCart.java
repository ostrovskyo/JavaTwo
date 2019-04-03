package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

//    @Column(name = "amount", columnDefinition = "float")
//    private BigDecimal amount;



//    private BigDecimal amount = new BigDecimal(0);

//    @OneToMany
//    @JoinColumn(name = "products_shopping_carts")
//    private List<Product> productList;

//    public void calculateTotalPrice() {
//        AmountCalculation amountCalculation = new AmountCalculation();
//        amount = amountCalculation.getTotalPrice(productList);
//    }

//        public void calculateTotalPrice() {
//        AmountCalculation amountCalculation = new AmountCalculation();
//        amount = amountCalculation.getTotalPrice(productList);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }

//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
