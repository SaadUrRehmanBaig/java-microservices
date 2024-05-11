package com.lcwd.user.service.userservice.externals;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.payload.ApiResponse;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/api/rating/user/{userId}")
    ApiResponse<List<Rating>> getRatingsByUserId(@PathVariable String userId);
}
