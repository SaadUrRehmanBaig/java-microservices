package com.lcwd.user.service.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.userservice.entities.User;

/**
 * UserRepositories
 */
public interface UserRepo extends JpaRepository<User,String> {

    
}