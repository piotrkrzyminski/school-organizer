package com.schoolorganizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home controller, accessed after login.
 */
@Controller
public class HomeController {

    @GetMapping
    public String getHome() {
        return "home";
    }
}
