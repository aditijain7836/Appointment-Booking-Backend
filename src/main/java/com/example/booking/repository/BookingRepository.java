package com.example.booking.repository;

import com.example.booking.models.Booking;
import com.example.booking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    //query will be defined such that the user will be searched inside booking, search for the user and then name inside user
    List<Booking> findByUser_Name(String name);
}
