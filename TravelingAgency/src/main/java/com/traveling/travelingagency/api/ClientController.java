package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/api/retrieveclients")
    public ArrayList<Base> retrieveClients(){
        return clientService.retrieveAll();
    }

    @GetMapping("/api/retrieveclientbyid")
    public Base retrieveClientById(@RequestParam int id){
        return clientService.retrieveById(id);
    }
    @PostMapping("/api/createclient")
    public void createClient(@RequestBody Base client){
        clientService.create(client);
    }
    @DeleteMapping("/api/deleteclient")
    public void deleteClient(@RequestParam int id){
        clientService.delete(id);
    }

}
