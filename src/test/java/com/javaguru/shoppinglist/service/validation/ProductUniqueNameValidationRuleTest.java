package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Mock
    private ProductInMemoryRepository database;

    @Spy
    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    private Product product = product();

    @Test
    public void shouldThrowException() {
        when(database.getProductByName(product.getName()))
                .thenReturn(Optional.of(product));

        assertThatThrownBy(() -> victim.validate(product))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Error: Product with name \"" + product.getName() + "\" already exists!");

        verify(victim).checkNotNull(product);
    }

    @Test
    public void shouldValidateSuccess() {
        when(database.getProductByName(product.getName()))
                .thenReturn(Optional.empty());

        victim.validate(product);

        verify(victim).checkNotNull(product);
    }

    private Product product() {
        Product product = new Product();
        product.setId(100L);
        product.setName("TEST NAME");
        product.setPrice(new BigDecimal(100));
        product.setCategory(Category.FRESH_PRODUCE);
        product.setDiscount(new BigDecimal(50));
        product.setDescription("TEST DESCRIPTION");
        product.setActualPrice(new BigDecimal(50));
        return product;
    }
}