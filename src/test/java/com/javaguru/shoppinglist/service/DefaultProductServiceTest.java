package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

    @Mock
    private ProductRepository productInMemoryRepository;

    @Mock
    private ProductValidationService productValidationService;

    @InjectMocks
    private DefaultProductService victim;

    @Captor
    private ArgumentCaptor<Product> productArgumentCaptor;

    @Test
    public void shouldCreateProduct() {
        Product product = product();
        when(productInMemoryRepository.insertProduct(product)).thenReturn(product.getId());

        Long result = victim.create(product);

        verify(productValidationService).validate(productArgumentCaptor.capture());
        Product captorResult = productArgumentCaptor.getValue();

        assertThat(captorResult).isEqualTo(product);
        assertThat(product.getId()).isEqualTo(result);
    }

    private Product product() {
        Product product = new Product();
        product.setId(100L);
        product.setName("NameTest");
        product.setPrice(new BigDecimal(100));
        product.setCategory(Category.FRESH_PRODUCE);
        product.setDiscount(new BigDecimal(10));
        product.setDescription("DescriptionTest");
        product.setActualPrice(new BigDecimal(90));
        return product;
    }




}