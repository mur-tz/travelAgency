package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Trip;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("/api/trip/retrieveall")
    public ArrayList<Base> retrieveTrip(){
        return tripService.retrieveAll();
    }

    @GetMapping("/api/trip/retrievebyid")
    public Base retrieveTripById(@RequestParam int id){
        return tripService.retrieveById(id);
    }
    @PostMapping("/api/trip/create")
    public void createTrip(@RequestBody Trip trip){
        tripService.create(trip);
    }
    @DeleteMapping("/api/trip/delete")
    public void deleteTrip(@RequestParam int id){
        tripService.delete(id);
    }
}
