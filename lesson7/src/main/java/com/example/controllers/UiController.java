package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UiController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admins")
    public String admin() {
        return "admins";
    }

    @GetMapping("/forms")
    public String forms() {
        return "forms";
    }
}
