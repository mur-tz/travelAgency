package com.traveling.travelingagency.dtos;

public class Service extends Base{
    private double PriceUSD;
    private String ServiceName, Description;

    public Service(int id, double priceUSD, String serviceName, String description) {
        super(id);
        PriceUSD = priceUSD;
        ServiceName = serviceName;
        Description = description;
    }

    public Service(int id) {
        super(id);
    }

    public double getPriceUSD() {
        return PriceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        PriceUSD = priceUSD;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
