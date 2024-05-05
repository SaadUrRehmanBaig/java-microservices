package com.lcwd.user.service.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.user.service.userservice.entities.User;

/**
 * UserRepositories
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {

}