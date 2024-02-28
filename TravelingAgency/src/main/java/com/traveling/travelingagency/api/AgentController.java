package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/api/agent/retrieveall")
    public ArrayList<Base> retrieveAgents(){
        return agentService.retrieveAll();
    }

    @GetMapping("/api/agent/retrievebyid")
    public Base retrieveAgentById(@RequestParam int id){
        return agentService.retrieveById(id);
    }
    @PostMapping("/api/agent/create")
    public void createAgent(@RequestBody Agent agent){
        agentService.create(agent);
    }
    @DeleteMapping("/api/agent/delete")
    public void deleteAgent(@RequestParam int id){
        agentService.delete(id);
    }
}
