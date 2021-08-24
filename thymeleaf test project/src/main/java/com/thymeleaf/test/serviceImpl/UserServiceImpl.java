package com.thymeleaf.test.serviceImpl;

import com.thymeleaf.test.entity.User;
import com.thymeleaf.test.entity.UserRole;
import com.thymeleaf.test.repository.UserRepository;
import com.thymeleaf.test.service.UserRoleService;
import com.thymeleaf.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String saveWithPasswordEncode(User user) throws Exception {
        Optional<User> userLoginCheck = userRepository.findByLogin(user.getLogin());

        if (userLoginCheck.isPresent()) {
            throw new Exception("User with login \"" + user.getLogin() + "\" already exists.");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setStatus(1L);
            user = userRepository.save(user);
            UserRole userRole = new UserRole();
            userRole.setRoleName("ROLE_USER");
            userRole.setUser(user);
            userRoleService.save(userRole);
            return "/index";
        }
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
