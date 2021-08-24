package com.thymeleaf.test.service;

import com.thymeleaf.test.entity.UserRole;
import com.thymeleaf.test.model.UserRoleModel;

public interface UserRoleService{
    UserRole save(UserRole userRole);
    UserRole save(UserRoleModel userRoleModel);
}
