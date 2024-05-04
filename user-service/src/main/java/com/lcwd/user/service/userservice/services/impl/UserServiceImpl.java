package com.lcwd.user.service.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.userservice.dto.UserSaveDto;
import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.userservice.repositories.UserRepo;
import com.lcwd.user.service.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ModelMapper modelMapper;

    @Autowired
    UserServiceImpl(ModelMapper modelMapper, UserRepo userRepo) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        PropertyMap<User, User> propertyMap = new PropertyMap<User, User>() {
            protected void configure() {
                skip().setUserId(null);
            }
        };

        modelMapper.addMappings(propertyMap);
    }

    @Override
    public User saveUser(UserSaveDto user) {
        User newUser = new User();
        modelMapper.map(user, newUser);
        newUser.setUserId(UUID.randomUUID().toString());
        return userRepo.save(newUser);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        modelMapper.map(user, existingUser);

        return userRepo.save(existingUser);
    }

    @Override
    public Void deleteUser(String userId) {
        User user = this.getUser(userId);
        userRepo.deleteById(user.getUserId());
        return null;
    }

}
