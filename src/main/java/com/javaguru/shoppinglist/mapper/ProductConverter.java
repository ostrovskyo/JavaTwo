package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDiscount(productDto.getDiscount());
        product.setDescription(productDto.getDescription());
        product.setActualPrice(productDto.getActualPrice());
        return product;
    }

    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setDiscount(product.getDiscount());
        productDto.setDescription(product.getDescription());
        productDto.setActualPrice(product.getActualPrice());
        return productDto;
    }
}
