package com.telusko.SpringWebAppJPA.repository;

import com.telusko.SpringWebAppJPA.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> { // mention the Product class and primary key type

}
