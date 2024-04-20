package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Booking;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @CrossOrigin
    @GetMapping("/api/booking/retrieveall")
    public ArrayList<Base> retrieveBookings(){
        return bookingService.retrieveAll();
    }

    @GetMapping("/api/booking/retrievebyid")
    public Base retrieveBookingById(@RequestParam int id){
        return bookingService.retrieveById(id);
    }
    @PostMapping("/api/booking/create")
    public void createBooking(@RequestBody Booking booking){
        bookingService.create(booking);
    }
    @PutMapping("/api/booking/update")
    public void updateBooking(@RequestBody Booking booking){
        bookingService.update(booking);
    }
    @DeleteMapping("/api/booking/delete")
    public void deleteBooking(@RequestParam int id){
        bookingService.delete(id);
    }


}
