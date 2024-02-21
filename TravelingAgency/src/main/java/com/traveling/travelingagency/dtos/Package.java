package com.traveling.travelingagency.dtos;

public class Package extends Base{
    private String Description;
    private Double Price;
    private int IdService; // Could work better as an intermediate class

    public Package(int id, String description, Double price, int idService) {
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

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int idService) {
        IdService = idService;
    }
}
