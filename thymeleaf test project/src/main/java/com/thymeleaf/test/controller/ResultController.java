package com.thymeleaf.test.controller;

import com.thymeleaf.test.entity.Result;
import com.thymeleaf.test.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/user_results")
    public String test(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Result> results = resultRepository.findAllByUserLogin(login);
        model.addAttribute("user_results", results);
        return "user_results";
    }
}
