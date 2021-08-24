package com.thymeleaf.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping({"/index" , "/index.html" , "/"})
    public String homePage() {
        return "/index";
    }
}
