package com.service.ratingservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.service.ratingservice.dtos.SaveRatingDto;
import com.service.ratingservice.entities.Rating;
import com.service.ratingservice.services.RatingService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping("")
    public Rating saveRating(@Valid @RequestBody SaveRatingDto rating) {
        return ratingService.saveRating(rating);
    }

    @DeleteMapping("")
    public Void deleteRating(String ratingId) {
        return ratingService.deleteRating(ratingId);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getAllRatingsByUserId(@PathVariable String userId) {
        return ratingService.getAllRatingByUserId(userId);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Rating> getAllRatingsByHotelId(@PathVariable String hotelId) {
        return ratingService.getAllRatingByHotelId(hotelId);
    }

    @GetMapping("")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRating();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable String id) {
        return ratingService.getRating(id);
    }

}
