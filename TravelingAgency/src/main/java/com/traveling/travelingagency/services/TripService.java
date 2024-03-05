package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.TripDao;
import com.traveling.travelingagency.models.Trip;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TripService implements Services{
    @Autowired
    private TripDao tripDao;
    @Override
    public void create(Base model) {

        Trip trip = (Trip)model;
        /*
        if (trip.getName() == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        */

        tripDao.create(trip);

    }

    @Override
    public void update(Base model) {
        System.out.println(model.getId());
    }

    @Override
    public Base retrieveById(int id) {
        return tripDao.retrieveById(id);
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        return tripDao.retrieveAll();
    }

    @Override
    public void delete(int id){
        tripDao.delete(id);
    }
}
