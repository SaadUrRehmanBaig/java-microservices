package com.lcwd.user.service.userservice.externals;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.userservice.entities.Hotel;
import com.lcwd.user.service.userservice.payload.ApiResponse;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/api/hotel/{hotelId}")
    ApiResponse<Hotel> getHotelById(@PathVariable String hotelId);
}
