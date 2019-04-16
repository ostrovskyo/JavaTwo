package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.ShoppingCartDto;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartConverter shoppingCartConverter;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ShoppingCartConverter shoppingCartConverter) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartConverter = shoppingCartConverter;
    }

    @GetMapping("/")
    public List<ShoppingCartDto> printAllShoppingCarts() {
        return shoppingCartService.printAllShoppingCarts();
    }

    @GetMapping("/{id}")
    public ShoppingCartDto FindShoppingCartById(@PathVariable("id") Long id) {
        ShoppingCartDto shoppingCartDto = shoppingCartConverter.convert(shoppingCartService.findById(id));
        return shoppingCartDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }
}
