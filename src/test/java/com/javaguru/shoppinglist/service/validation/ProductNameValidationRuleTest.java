package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductNameValidationRule victim = new ProductNameValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductNameValidationException() {
        input = productSetName(null);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name cannot be null!");


    }

    @Test
    public void shouldValidateSuccess() {
        input = productSetName("valid name");
        victim.validate(input);
    }

    private Product productSetName(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}