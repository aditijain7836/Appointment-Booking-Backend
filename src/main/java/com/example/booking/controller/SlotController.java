package com.example.booking.controller;

import com.example.booking.models.Booking;
import com.example.booking.models.Slot;
import com.example.booking.models.User;
import com.example.booking.requests.SlotDto;
import com.example.booking.service.SlotService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class SlotController {

    @Autowired
    private SlotService slotService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/book/slot")
    public ResponseEntity<Booking> bookSlot(@RequestBody SlotDto slotDto)
    {
        Booking booking = slotService.bookSlot(slotDto);
        return ResponseEntity.ok(booking);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/slots")
    public ResponseEntity<List<Slot>> getAllSlots()
    {
        List<Slot> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/appointment")
    public ResponseEntity<List<Booking>> getUserBooking(@RequestParam String userName)
    {
        List<Booking> bookings = slotService.getUserBooking(userName);
        return ResponseEntity.ok(bookings);
    }

}
