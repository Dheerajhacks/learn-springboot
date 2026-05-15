package com.telusko.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

@Component
public class Dev {

    @Autowired
    @Qualifier("laptop")
    private Computer comp;

    public void build(){
        comp.compile();
        System.out.println("Working on awesome project.!!");
    }
}
