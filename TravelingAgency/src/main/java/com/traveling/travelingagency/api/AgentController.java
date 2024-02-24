package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/retrieveagents")
    public ArrayList<Base> RetrieveAgents(){
        return agentService.RetrieveAll();
    }
}
