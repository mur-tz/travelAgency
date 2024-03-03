package com.traveling.travelingagency.models;

public class Agent extends  Base{
    private String Name, LastName1, LastName2;

    public Agent(int id, String name, String lastName1, String lastName2) {
        super(id);
        Name = name;
        LastName1 = lastName1;
        LastName2 = lastName2;
    }

    public Agent(int id) {
        super(id);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String lastName1) {
        LastName1 = lastName1;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String lastName2) {
        LastName2 = lastName2;
    }

}
