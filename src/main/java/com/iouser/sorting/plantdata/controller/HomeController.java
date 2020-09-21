package com.iouser.sorting.plantdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "login/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "home/index";
    }

}
