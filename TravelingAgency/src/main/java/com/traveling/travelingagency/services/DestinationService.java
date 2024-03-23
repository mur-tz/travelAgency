package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.DestinationDao;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DestinationService implements Services{
    @Autowired
    private DestinationDao destinationDao;
    @Override
    public void create(Base model) {
        Destination des = (Destination)model;
        destinationDao.create(des);
    }

    @Override
    public void update(Base model) {
        Destination des = (Destination)model;
        destinationDao.update(des);
    }

    @Override
    public Base retrieveById(int id) {
        return destinationDao.retrieveById(id);
    }

    @Override
    public List<Base> retrieveAll() {
        return destinationDao.retrieveAll();
    }

    @Override
    public void delete(int id) {
        destinationDao.delete(id);
    }
}
