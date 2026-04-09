package com.example.session02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping(value = {"/","/products"})

public class ProductController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("name","PQT");
        return "listProducts.jsp";
    }
}