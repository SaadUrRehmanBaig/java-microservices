package com.service.ratingservice.services;

import java.util.List;

import com.service.ratingservice.dtos.SaveRatingDto;
import com.service.ratingservice.entities.Rating;

public interface RatingService {
    List<Rating> getAllRating();

    Rating getRating(String ratingId);

    List<Rating> getAllRatingByUserId(String userId);

    List<Rating> getAllRatingByHotelId(String hotelId);

    Rating saveRating(SaveRatingDto rating);

    Void deleteRating(String ratingId);

}