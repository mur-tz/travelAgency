package com.traveling.travelingagency.services;

import com.traveling.travelingagency.models.Base;

import java.util.List;

public interface Services {
    public void create(Base model);
    public void update(Base model);
    public Base retrieveById(int id);
    public List<Base> retrieveAll();
    public void delete(int id);
}
