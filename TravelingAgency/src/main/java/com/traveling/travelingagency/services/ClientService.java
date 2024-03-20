package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.ClientDao;
import com.traveling.travelingagency.models.Client;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService implements Services{
    @Autowired
    private ClientDao clientDao;

    @Override
    public void create(Base model) {
        Client client = (Client)model;
        if (client.getName() == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        clientDao.create(client);

    }

    @Override
    public void update(Base model) {
        Client client = (Client)model;
        clientDao.update(client);
    }

    @Override
    public Base retrieveById(int id) {
        return clientDao.retrieveById(id);
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        return clientDao.retrieveAll();
    }

    @Override
    public void delete(int id) {
        clientDao.delete(id);
    }
}
