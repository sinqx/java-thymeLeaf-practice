package com.thymeleaf.test.serviceImpl;

import com.thymeleaf.test.entity.Word;
import com.thymeleaf.test.model.AttemptModel;
import com.thymeleaf.test.repository.WordRepository;
import com.thymeleaf.test.service.WordService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WordServiceImpl implements WordService{
    @Autowired
    private WordRepository wordRepository;


    @Override
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word findById(Long id) {
        return wordRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,"error"));
    }

    @Override
    public void deleteWordById(Long id) {
         wordRepository.deleteById(id);
    }

    @Override
    public Word giveWord(){
        Random random = new Random();
        long quantity  = wordRepository.count();
        long randomId = random.nextInt((int)quantity)+1;
        return findById(randomId);
    }

    @Override
    public AttemptModel attempt(AttemptModel attempt){
        String word = attempt.getWord();
        String letters = attempt.getLetters();
        StringBuilder hided = attempt.getHided();
        if (word.equals(letters))
        {
            return null;
        }else if(letters.length() == 1 && word.contains(letters)){
           char a = letters.charAt(0);
           hided.setCharAt(word.indexOf(a), a);
        }
        attempt.setHided(hided);
        attempt.setLetters("");
        return attempt;
    }
}
