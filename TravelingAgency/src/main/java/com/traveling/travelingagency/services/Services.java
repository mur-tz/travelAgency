package com.traveling.travelingagency.services;

import com.traveling.travelingagency.models.Base;

import java.util.List;

public interface Services {
    public void Create(Base model);
    public void Update(Base model);
    public Base RetrieveById(int id);
    public List<Base> RetrieveAll();
    public void Delete(int id);
}
