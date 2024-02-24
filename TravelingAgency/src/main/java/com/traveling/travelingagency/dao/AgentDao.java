package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AgentDao implements DaoInterf{
    @Override
    public void Create(Base model) {
        Agent agent = (Agent)model;
        System.out.println("Agent created" + agent.getClientId());
    }

    @Override
    public void Update(Base model) {
        Agent agent = (Agent)model;
        System.out.println("Agent created" + agent.getClientId());
    }

    @Override
    public Base RetrieveById(int id) {
        return null;
    }

    @Override
    public ArrayList<Base> RetrieveAll() {
        ArrayList<Base> agents = new ArrayList<>();
        agents.add(new Agent(1, "Juan", "Martinez", "", 3));
        agents.add(new Agent(2, "Kendall", "Duran", "", 3));
        agents.add(new Agent(3, "Ivan", "Wu", "", 3));
        agents.add(new Agent(4, "Paz", "Narrow", "", 3));
        return agents;
    }

    @Override
    public void Delete(int id) {
        System.out.println(id);
    }
}
