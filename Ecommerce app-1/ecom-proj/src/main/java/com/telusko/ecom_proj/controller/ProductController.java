package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin // if we dont add this we will get cors error when we try to access the api from frontend because some website bloc the other api to access their data for security reason so we need to add this annotation to allow the api to be accessed from other website
@RequestMapping("/api")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/")
    public String greet(){
        return "Welcome to the E-commerce API!";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
}
