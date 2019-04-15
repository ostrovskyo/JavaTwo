package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDto productDto) {
        Product task = new Product();
        task.setDescription(productDto.getDescription());
        task.setName(productDto.getName());
        task.setId(productDto.getId());
        return task;
    }

    public ProductDto convert(Product product) {
        ProductDto taskDto = new ProductDto();
        taskDto.setDescription(product.getDescription());
        taskDto.setName(product.getName());
        taskDto.setId(product.getId());
        return taskDto;
    }
}
