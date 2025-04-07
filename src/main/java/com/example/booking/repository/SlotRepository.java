package com.example.booking.repository;

import com.example.booking.models.Slot;
import com.example.booking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

    //Option<Slot> means getting 0 or 1 result but List<Slot> refers to multiple results
    List<Slot> findByStatus(String status);
}
