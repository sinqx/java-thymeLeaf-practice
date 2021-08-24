package com.thymeleaf.test.serviceImpl;

import com.thymeleaf.test.entity.Result;
import com.thymeleaf.test.repository.ResultRepository;
import com.thymeleaf.test.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResultById(Long id) {
        resultRepository.deleteById(id);
    }
}
