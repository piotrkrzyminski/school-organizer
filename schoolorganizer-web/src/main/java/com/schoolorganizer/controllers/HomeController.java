package com.schoolorganizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller, accessed after login.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome() {
        return "home";
    }
}
