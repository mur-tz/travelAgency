package com.traveling.travelingagency.dtos;

import java.time.LocalDateTime;

public class Trip extends Base{
    private LocalDateTime ArrivalDate, DepartureDate;

    public Trip(int id, LocalDateTime arrivalDate, LocalDateTime departureDate) {
        super(id);
        ArrivalDate = arrivalDate;
        DepartureDate = departureDate;
    }

    public Trip(int id) {
        super(id);
    }

    public LocalDateTime getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        DepartureDate = departureDate;
    }
}
