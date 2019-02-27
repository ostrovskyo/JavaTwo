package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    private Product input;

    @Test
    public void shouldTrowProductPriceValidationException() {
        input = productSetPrice(new BigDecimal(-100));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal price!");
    }

    private Product productSetPrice(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }

    @Test
    public void shouldValidateSuccess() {
        input = productSetPrice(new BigDecimal(100));

        victim.validate(input);
    }
}