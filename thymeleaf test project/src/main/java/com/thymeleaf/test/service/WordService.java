package com.thymeleaf.test.service;


import com.thymeleaf.test.entity.Word;
import com.thymeleaf.test.model.AttemptModel;

public interface WordService {
    Word save(Word word);
    Word findById(Long id);
    Word giveWord();
    AttemptModel attempt(AttemptModel attemptModel);
    void deleteWordById(Long id);

}
