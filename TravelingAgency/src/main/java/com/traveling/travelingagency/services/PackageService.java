package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.PackageDao;
import com.traveling.travelingagency.models.Package;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class PackageService {

    @Autowired
    private PackageDao packageDao;

    public void create(Base model) {
        Package packageModel = (Package)model;
        if (packageModel.getId() == 0){
            throw new IllegalArgumentException("El paquete no puede ser nulo");
        }
        packageDao.create(packageModel);

    }

    public void update(Base model) {
        Package packageModel = (Package)model;
        packageDao.update(packageModel);
    }

    public Base retrieveById(int id) {
        return packageDao.retrieveById(id);
    }

    public ArrayList<Base> retrieveAll() {
        return packageDao.retrieveAll();
    }

    public void delete(int id){
        packageDao.delete(id);
    }



}
