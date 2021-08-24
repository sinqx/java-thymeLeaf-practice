package com.thymeleaf.test.service;

import com.thymeleaf.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService{
    String saveWithPasswordEncode(User user) throws Exception;
    User findByLogin(String username);
    User findById(Long id);
    List<User> findAllUsers();
    User save(User user);
}
