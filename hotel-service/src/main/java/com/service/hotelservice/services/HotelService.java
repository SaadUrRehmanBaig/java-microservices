package com.service.hotelservice.services;

import java.util.List;

import com.service.hotelservice.dtos.HotelSaveDto;
import com.service.hotelservice.entities.Hotel;

public interface HotelService {
    Hotel saveHotel(HotelSaveDto hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);

    Void deleteHotel(String hotelId);
}
