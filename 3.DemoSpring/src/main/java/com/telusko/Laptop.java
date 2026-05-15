package com.telusko;

public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Laptop Constructor called..!!");
    }
    public void compile(){
        System.out.println("Compiling in laptop...");
    }
}
