package com.thymeleaf.test.controller;

import com.thymeleaf.test.entity.User;
import com.thymeleaf.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/sign-up")
    public String save(User user) throws Exception {
        userService.saveWithPasswordEncode(user);
        return "/reg_complete";
    }
}
