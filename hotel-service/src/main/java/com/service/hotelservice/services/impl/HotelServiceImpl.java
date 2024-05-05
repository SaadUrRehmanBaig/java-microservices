package com.service.hotelservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotelservice.dtos.HotelSaveDto;
import com.service.hotelservice.entities.Hotel;
import com.service.hotelservice.exceptions.ResourceNotFoundException;
import com.service.hotelservice.repositories.HotelRepo;
import com.service.hotelservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Hotel saveHotel(HotelSaveDto hotel) {
        Hotel newHotel = new Hotel();
        modelMapper.map(hotel, newHotel);
        newHotel.setId(UUID.randomUUID().toString());
        return hotelRepo.save(newHotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
    }

    @Override
    public Void deleteHotel(String hotelId) {
        hotelRepo.deleteById(this.getHotel(hotelId).getId());
        return null;
    }

}
