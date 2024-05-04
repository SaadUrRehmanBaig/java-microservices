package com.lcwd.user.service.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.userservice.dto.UserSaveDto;
import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.services.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserSaveDto user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("")
    List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable String id) {
        return userService.getUser(id);
    }
}
