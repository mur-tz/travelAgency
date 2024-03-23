package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Client;
import com.traveling.travelingagency.models.Destination;
import com.traveling.travelingagency.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DestinationController {
    @Autowired
    private DestinationService destinationService;
    @GetMapping("/api/destination/retrieveall")
    public ArrayList<Base> retrieveDestinations(){
        return (ArrayList<Base>) destinationService.retrieveAll();
    }

    @GetMapping("/api/destination/retrievebyid")
    public Base retrieveClientById(@RequestParam int id){
        return destinationService.retrieveById(id);
    }
    @PostMapping("/api/destination/create")
    public void createClient(@RequestBody Destination dest){
        destinationService.create(dest);
    }
    @PutMapping("/api/destination/update")
    public void updateAgent(@RequestBody Destination dest){
        destinationService.update(dest);
    }
    @DeleteMapping("/api/destination/delete")
    public void deleteClient(@RequestParam int id){
        destinationService.delete(id);
    }
}
