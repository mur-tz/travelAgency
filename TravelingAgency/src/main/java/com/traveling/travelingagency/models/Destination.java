package com.traveling.travelingagency.models;

public class Destination extends Base{
    private String Country, City, Airport;
    private int TripId;

    public Destination(int id, String country, String city, String airport, int tripId) {
        super(id);
        Country = country;
        City = city;
        Airport = airport;
        TripId = tripId;
    }

    public Destination(int id) {
        super(id);
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAirport() {
        return Airport;
    }

    public void setAirport(String airport) {
        Airport = airport;
    }

    public int getTripId() {
        return TripId;
    }

    public void setTripId(int tripId) {
        TripId = tripId;
    }
}
