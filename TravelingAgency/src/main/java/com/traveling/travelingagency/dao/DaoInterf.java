package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Base;

import java.util.ArrayList;

public interface DaoInterf {
    public void create(Base model);
    public void update(Base model);
    public Base retrieveById(int id);
    public ArrayList<Base> retrieveAll();
    public void delete(int id);
}
