package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Client;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/api/client/retrieveall")
    public ArrayList<Base> retrieveClients(){
        return clientService.retrieveAll();
    }

    @GetMapping("/api/client/retrievebyid")
    public Base retrieveClientById(@RequestParam int id){
        return clientService.retrieveById(id);
    }
    @PostMapping("/api/client/create")
    public void createClient(@RequestBody Client client){
        clientService.create(client);
    }
    @PutMapping("/api/client/update")
    public void updateAgent(@RequestBody Client client){
        clientService.update(client);
    }
    @DeleteMapping("/api/client/delete")
    public void deleteClient(@RequestParam int id){
        clientService.delete(id);
    }
}
