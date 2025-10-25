package com.mavu.product-api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ApiController {

    @GetMapping("/products")
    public void getAllProducts() {
        // TODO implement getAllProducts
    }

    @PostMapping("/products")
    public void createProduct() {
        // TODO implement createProduct
    }

    @GetMapping("/products/{id}")
    public void getProductById() {
        // TODO implement getProductById
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct() {
        // TODO implement deleteProduct
    }

    @GetMapping("/orders")
    public void getAllOrders() {
        // TODO implement getAllOrders
    }

    @PostMapping("/orders")
    public void createOrder() {
        // TODO implement createOrder
    }

}
