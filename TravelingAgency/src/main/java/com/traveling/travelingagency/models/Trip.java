package com.traveling.travelingagency.models;

import java.sql.Date;
import java.time.LocalDateTime;


public class Trip extends Base{
    private Date ArrivalDate, DepartureDate;
    private int Fk_Destination_id;

    public Trip(int id, Date arrivalDate, Date departureDate) {
        super(id);
        ArrivalDate = arrivalDate;
        DepartureDate = departureDate;
    }

    public Trip(int id) {
        super(id);
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public int getFkDestinationId() {
        return Fk_Destination_id;
    }

    public void setFkDestinationId(int fkDestinationId) {
        this.Fk_Destination_id = fkDestinationId;
    }
}
