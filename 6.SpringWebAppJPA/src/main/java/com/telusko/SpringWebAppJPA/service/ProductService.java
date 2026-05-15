package com.telusko.SpringWebAppJPA.service;

import com.telusko.SpringWebAppJPA.model.Product;
import com.telusko.SpringWebAppJPA.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    //List<Product> products = new ArrayList<>(Arrays.asList( new Product(101, "iphone", 50000), new Product(102, "android", 25000)));

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public void addproduct(Product prod){
        repo.save(prod);
    }


    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
