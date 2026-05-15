package com.telusko.SpringWebAppJPA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to telusko..!!";
    }

    @RequestMapping("/about")
    public String about(){
        return "this is the about page";
    }
}
