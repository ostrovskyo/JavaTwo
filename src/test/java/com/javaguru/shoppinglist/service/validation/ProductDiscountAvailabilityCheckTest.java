package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductDiscountAvailabilityCheckTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDiscountAvailabilityCheck victim = new ProductDiscountAvailabilityCheck();
    private Product input;

    @Test
    public void shouldThrowProductDiscountAvailabilityException() {
        input = productSetDiscount(new BigDecimal(10), new BigDecimal(50));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Error!!! Discount cannot be set if price is less than 20$");
    }

    @Test
    public void shouldValidateSuccess() {
        input = productSetDiscount(new BigDecimal(22), new BigDecimal(10));
        victim.validate(input);
    }

    private Product productSetDiscount(BigDecimal price, BigDecimal discount) {
        Product product = new Product();
        product.setPrice(price);
        product.setDiscount(discount);
        return product;
    }



}