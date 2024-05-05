package com.service.ratingservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ratingservice.dtos.SaveRatingDto;
import com.service.ratingservice.entities.Rating;
import com.service.ratingservice.exceptions.ResourceNotFoundException;
import com.service.ratingservice.repositories.RatingRepo;
import com.service.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating not Found"));
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating saveRating(SaveRatingDto rating) {
        Rating newRating = modelMapper.map(rating, Rating.class);

        // Set ratingId separately
        newRating.setRatingId(UUID.randomUUID().toString());
        return ratingRepo.save(newRating);
    }

    @Override
    public Void deleteRating(String ratingId) {
        ratingRepo.deleteById(this.getRating(ratingId).getRatingId());
        return null;
    }

}
