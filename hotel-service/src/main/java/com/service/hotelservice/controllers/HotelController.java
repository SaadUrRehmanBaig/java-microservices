package com.service.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.hotelservice.dtos.HotelSaveDto;
import com.service.hotelservice.entities.Hotel;
import com.service.hotelservice.services.impl.HotelServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelServiceImpl hotelService;

    @PostMapping("")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody HotelSaveDto hotel) {
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @GetMapping("")
    List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    Hotel getUserById(@PathVariable String id) {
        return hotelService.getHotel(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }
}
