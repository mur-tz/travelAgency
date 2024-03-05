package com.traveling.travelingagency.models;

import java.time.LocalDate;
import java.sql.Date;

public class Booking extends Base{
    private Date BookingDate, BookingStartDate, BookingEndDate;
    private int PeopleCount, ClientId, AgentId, IdPackage, IdDestination;

    public Booking(int id, Date bookingDate, Date bookingStartDate, Date bookingEndDate, int peopleCount, int clientId, int agentId, int idPackage, int idDestination) {
        super(id);
        BookingDate = bookingDate;
        BookingStartDate = bookingStartDate;
        BookingEndDate = bookingEndDate;
        PeopleCount = peopleCount;
        ClientId = clientId;
        AgentId = agentId;
        IdPackage = idPackage;
        IdDestination = idDestination;
    }

    public Booking(int id) {
        super(id);
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public Date getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        BookingStartDate = bookingStartDate;
    }

    public Date getBookingEndDate() {
        return BookingEndDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        BookingEndDate = bookingEndDate;
    }

    public int getPeopleCount() {
        return PeopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        PeopleCount = peopleCount;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }

    public int getIdPackage() {
        return IdPackage;
    }

    public void setIdPackage(int idPackage) {
        IdPackage = idPackage;
    }

    public int getIdDestination() {
        return IdDestination;
    }

    public void setIdDestination(int idDestination) {
        IdDestination = idDestination;
    }
}
