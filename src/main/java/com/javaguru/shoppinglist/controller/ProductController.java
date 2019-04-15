package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ProductDto.Create.class}) @RequestBody ProductDto productDto,
                                       UriComponentsBuilder builder) {
        Long id = productService.create(productDto);
        return ResponseEntity.created(builder.path("/tasks/{id}").buildAndExpand(id).toUri()).build();
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable Long id, @Validated({ProductDto.Update.class}) @RequestBody ProductDto taskDto) {
//        productService.updateTask(taskDto);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        productService.deleteTask(id);
//    }
//
//    @GetMapping("/{id}")
//    public ProductDto findProductById(@PathVariable("id") Long id) {
//        return productService.findById(id);
//    }
//
//    @GetMapping(params = "name")
//    public ProductDto findTaskByName(@RequestParam("name") String name) {
//        return productService.findTaskByName(name);
//    }
//
//    @GetMapping
//    public List<ProductDto> findAll() {
//        return productService.findAll();
//    }
//
//    @ExceptionHandler(NoSuchElementException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public void handleNoSuchElementException(NoSuchElementException ex) {
//
//    }

}
