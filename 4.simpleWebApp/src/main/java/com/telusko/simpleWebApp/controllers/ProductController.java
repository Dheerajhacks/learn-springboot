package com.telusko.simpleWebApp.controllers;

import com.telusko.simpleWebApp.model.Product;
import com.telusko.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    //@RequestMapping("/products") // by default the methods are get methods
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
        // someone is converting java object to json and viceversa
        // i.e jackson library
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addproduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);

    }
}
