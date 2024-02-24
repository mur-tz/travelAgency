package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Base;

import java.util.ArrayList;
import java.util.List;

public interface DaoInterf {
    public void Create(Base model);
    public void Update(Base model);
    public Base RetrieveById(int id);
    public ArrayList<Base> RetrieveAll();
    public void Delete (int id);
}
