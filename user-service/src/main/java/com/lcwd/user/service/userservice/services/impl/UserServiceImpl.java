package com.lcwd.user.service.userservice.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.userservice.dto.UserSaveDto;
import com.lcwd.user.service.userservice.entities.Hotel;
import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.userservice.externals.HotelService;
import com.lcwd.user.service.userservice.externals.RatingService;
import com.lcwd.user.service.userservice.repositories.UserRepo;
import com.lcwd.user.service.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ModelMapper modelMapper;
    private HotelService hotelService;
    private RatingService ratingService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserServiceImpl(ModelMapper modelMapper, UserRepo userRepo, HotelService hotelService,
            RatingService ratingService) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.hotelService = hotelService;
        this.ratingService = ratingService;
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
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> {
            List<Rating> ratings = this.ratingService.getRatingsByUserId(user.getUserId()).getData();
            List<Rating> ratingList = ratings.stream().map((rating) -> {
                rating.setHotel(this.hotelService.getHotelById(rating.getHotelId()).getData());
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(ratingList);
            return user;
        }).toList();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        List<Rating> ratings = this.ratingService.getRatingsByUserId(user.getUserId()).getData();
        List<Rating> ratingList = ratings.stream().map((rating) -> {
            rating.setHotel(this.hotelService.getHotelById(rating.getHotelId()).getData());
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
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
