package com.telusko.SpringWebAppJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    public Product() {
    }
    //frameworks like JPA/Hibernate create objects using reflection.
    //When Hibernate fetches data from the database, it does something conceptually like this:
    //Product p = Product.class.getDeclaredConstructor().newInstance();
    //Then it fills the fields:
    //p.setProdId(...);
    //p.setProdName(...);
    //p.setPrice(...);
    //So Hibernate needs a constructor that it can call without arguments.

    public Product(int prodId, String prodName, int price) {

        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Id
    private int prodId;
    private String prodName;
    private int price;
}
