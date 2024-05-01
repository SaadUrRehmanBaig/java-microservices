package com.lcwd.user.service.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.services.impl.UserServiceImpl;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable String id) {
        return userService.getUser(id);
    }
}
