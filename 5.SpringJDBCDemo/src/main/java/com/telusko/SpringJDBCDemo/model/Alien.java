package com.telusko.SpringJDBCDemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // by default, Spring beans are singleton, so we need to specify prototype scope to get a new instance every time
// else we will get the same data every time we call getBean() method, which is not what we want in this case
// we will get multiple references with the same object, which is not what we want in this case
public class Alien {
    private int id;
    private String name;
    private String tech;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
