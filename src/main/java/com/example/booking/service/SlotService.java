package com.example.booking.service;

import com.example.booking.models.Booking;
import com.example.booking.models.Slot;
import com.example.booking.models.User;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.SlotRepository;
import com.example.booking.repository.UserRepository;
import com.example.booking.requests.SlotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookSlot(SlotDto slotDto)
    {
        Optional<Slot> slot = slotRepository.findById(slotDto.getSlotId());

        if(slot.isEmpty() || !slot.get().getStatus().equals("Available"))
            throw new RuntimeException("Slot not available");

        Optional<User> user = userRepository.findById(slotDto.getUserId());

        if(user.isEmpty())
            throw new RuntimeException("User not found");

        User userRecord = user.get();
        Slot slotRecord = slot.get();

        slotRecord.setStatus("Booked");
        slotRepository.save(slotRecord);

        Booking booking = new Booking();

        booking.setSlot(slotRecord);
        booking.setUser(userRecord);
        booking.setBookingTime(new Date());
        booking.setPaymentStatus("Pending");

        bookingRepository.save(booking);

        return booking;
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findByStatus("Available");
    }
}
