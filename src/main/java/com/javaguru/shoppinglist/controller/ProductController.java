package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ProductDto.Create.class}) @RequestBody ProductDto productDto,
                                       UriComponentsBuilder builder) {
        Long id = productService.create(productDto);
        return ResponseEntity.created(builder.path("/products/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping("/")
    public List<ProductDto> printAllProducts() {
        return productService.printAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable("id") Long id) {
        ProductDto productDto = productConverter.convert(productService.findById(id));
        return productDto;
    }
}