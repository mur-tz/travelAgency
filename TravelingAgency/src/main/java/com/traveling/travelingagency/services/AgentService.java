package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.AgentDao;
import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@Service
public class AgentService implements Services{
    @Autowired
    private AgentDao agentDao;
    @Override
    public void Create(Base model) {
        Agent agent = (Agent)model;
        // Validaciones del negocio
        agentDao.Create(agent);

    }

    @Override
    public void Update(Base model) {
        System.out.println(model.getId());
    }

    @Override
    public Base RetrieveById(int id) {
        return null;
    }

    @Override
    public ArrayList<Base> RetrieveAll() {
        return agentDao.RetrieveAll();
    }

    @Override
    public void Delete(int id) {
        System.out.println(id);
    }
}
