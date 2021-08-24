package com.thymeleaf.test.serviceImpl;

import com.thymeleaf.test.entity.User;
import com.thymeleaf.test.entity.UserRole;
import com.thymeleaf.test.model.UserRoleModel;
import com.thymeleaf.test.repository.UserRoleRepository;
import com.thymeleaf.test.service.UserRoleService;
import com.thymeleaf.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole save(UserRoleModel userRoleModel) {
        UserRole userRole = new UserRole();
        userRole.setRoleName(userRoleModel.getRoleName());
        User user = userService.findById(userRoleModel.getUserId());

        if(user == null) throw new IllegalArgumentException("Пользователь с ID " + userRoleModel.getUserId() + " не найден");
        userRole.setUser(user);

        return userRoleRepository.save(userRole);
    }
}
