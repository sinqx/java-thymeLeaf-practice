package com.thymeleaf.test.service;

import com.thymeleaf.test.entity.Result;

public interface ResultService {
    Result save(Result result);
    void deleteResultById(Long id);
}
