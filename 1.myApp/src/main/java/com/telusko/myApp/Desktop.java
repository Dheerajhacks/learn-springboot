package com.telusko.myApp;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Override
    public void compile(){
        System.out.println("Compiling with 404 bugs but faster");
    }
}
