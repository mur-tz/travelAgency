package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/api/retrievebookings")
    public ArrayList<Base> retrieveBookings(){
        return bookingService.retrieveAll();
    }

    @GetMapping("/api/retrievebookingbyid")
    public Base retrieveBookingById(@RequestParam int id){
        return bookingService.retrieveById(id);
    }
    @PostMapping("/api/createbooking")
    public void createBooking(@RequestBody Base booking){
        bookingService.create(booking);
    }
    @DeleteMapping("/api/deletebooking")
    public void deleteBooking(@RequestParam int id){
        bookingService.delete(id);
    }
}
