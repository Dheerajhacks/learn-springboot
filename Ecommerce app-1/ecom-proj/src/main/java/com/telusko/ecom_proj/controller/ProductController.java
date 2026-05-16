package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
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
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getProductById(id);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/product")
//    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
//        try {
//            System.out.println(product);
//            Product product1 = service.addProduct(product, imageFile);
//            return new ResponseEntity<>(product1, HttpStatus.CREATED);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>( e.getClass().getName() + " : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
@PostMapping("/product")
public ResponseEntity<?> addProduct(
        @RequestPart("product") String productJson,
        @RequestPart("imageFile") MultipartFile imageFile) {

    try {

        ObjectMapper mapper = new ObjectMapper();

        Product product = mapper.readValue(productJson, Product.class);

        System.out.println(product);

        Product savedProduct = service.addProduct(product, imageFile);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    } catch (Exception e) {

        e.printStackTrace();

        return new ResponseEntity<>(
                e.getClass().getName() + " : " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable Integer productId){
        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
        Product product1 = service.updateProduct(id, product, imageFile);
        if(product1 != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        return new ResponseEntity<>("Falied to Update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
