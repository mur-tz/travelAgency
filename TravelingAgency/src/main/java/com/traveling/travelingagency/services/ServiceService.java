package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.ServiceDao;
import com.traveling.travelingagency.models.Services;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceService implements com.traveling.travelingagency.services.Services {
    @Autowired
    private ServiceDao serviceDao;
    @Override
    public void create(Base model) {
        Services service = (Services)model;
        if (service.getServiceName() == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        serviceDao.create(service);

    }

    @Override
    public void update(Base model) {
        System.out.println(model.getId());
    }

    @Override
    public Base retrieveById(int id) {
        return serviceDao.retrieveById(id);
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        return serviceDao.retrieveAll();
    }

    @Override
    public void delete(int id){
        serviceDao.delete(id);
    }
}
