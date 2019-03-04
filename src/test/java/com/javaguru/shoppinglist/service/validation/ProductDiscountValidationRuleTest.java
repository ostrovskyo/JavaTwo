package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private Product input;

    @Test
    public void shouldThrowIllegalDiscountUpperMarginException() {
        input = setProductDiscount(new BigDecimal(100), new BigDecimal(101));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal discount!");
    }

    @Test
    public void shouldThrowIllegalDiscountLowerMarginException() {
        input = setProductDiscount(new BigDecimal(100), new BigDecimal(-1));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal discount!");
    }

    @Test
    public void shouldValidateSuccess() {
        input = setProductDiscount(new BigDecimal(100), new BigDecimal(50));
        victim.validate(input);
    }

    private Product setProductDiscount(BigDecimal price, BigDecimal discount) {
        Product product = new Product();
        product.setPrice(price);
        product.setDiscount(discount);
        return product;
    }



}