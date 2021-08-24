package com.thymeleaf.test.controller;

import com.thymeleaf.test.entity.Word;
import com.thymeleaf.test.model.AttemptModel;
import com.thymeleaf.test.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/start_game")
    public String startGame(Model model) {
        Word word = wordService.giveWord();
        model.addAttribute("word", word);
        model.addAttribute("attemptModel", new AttemptModel());
        return "/start_game";
    }

    @PostMapping("/game_attempt")
    public String attempt(AttemptModel attemptModel, Word word, Model model) {
        attemptModel.setWord(word.getName());
        AttemptModel newHided = wordService.attempt(attemptModel);
        model.addAttribute("newHided", newHided);
        return "/start_game";
    }
}
