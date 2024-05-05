package com.service.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.hotelservice.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
