package com.traveling.travelingagency.models;

public class Package extends Base{
    private String Description;
    private Double Price;
    private int IdService;

    public Package(int id, String description, double price, int idService) {
        super(id);
        Description = description;
        Price = price;
        IdService = idService;
    }

    public Package(int id) {
        super(id);
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int idService) {
        IdService = idService;
    }
}
