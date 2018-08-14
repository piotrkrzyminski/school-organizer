package com.schoolorganizer.web.controllers;

import com.schoolorganizer.model.user.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("user", new UserModel());

        return "login";
    }
}
