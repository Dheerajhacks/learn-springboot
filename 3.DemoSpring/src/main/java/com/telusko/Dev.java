package com.telusko;


public class Dev {

    Computer comp;

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public Dev(){
        System.out.println("Dev Constructor called..!!");
    }
    public void build(){
        comp.compile();
        System.out.println("Working on awesome project.!!");
    }
}
