package com.lcwd.user.service.userservice.services;

import java.util.List;

import com.lcwd.user.service.userservice.dto.UserSaveDto;
import com.lcwd.user.service.userservice.entities.User;

public interface UserService {
    User saveUser(UserSaveDto user);

    List<User> getAllUser();

    User getUser(String userId);

    User updateUser(User user);

    Void deleteUser(String userId);

}