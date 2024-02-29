package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Services;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/api/service/retrieveall")
    public ArrayList<Base> retrieveServices(){
        return serviceService.retrieveAll();
    }

    @GetMapping("/api/service/retrievebyid")
    public Base retrieveServiceById(@RequestParam int id){
        return serviceService.retrieveById(id);
    }
    @PostMapping("/api/service/create")
    public void createService(@RequestBody Services service){
        serviceService.create(service);
    }
    @DeleteMapping("/api/service/delete")
    public void deleteService(@RequestParam int id){
        serviceService.delete(id);
    }
}
