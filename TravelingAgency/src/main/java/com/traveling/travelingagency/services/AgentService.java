package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.AgentDao;
import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class AgentService implements Services{
    @Autowired
    private AgentDao agentDao;
    @Override
    public void create(Base model) {
        Agent agent = (Agent)model;
        if (agent.getName() == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        agentDao.create(agent);

    }

    @Override
    public void update(Base model) {
        Agent agent = (Agent)model;
        agentDao.update(agent);
    }

    @Override
    public Base retrieveById(int id) {
        return agentDao.retrieveById(id);
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        return agentDao.retrieveAll();
    }

    @Override
    public void delete(int id){
        agentDao.delete(id);
    }
}
