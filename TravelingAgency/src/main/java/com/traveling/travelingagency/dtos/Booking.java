package com.traveling.travelingagency.dtos;

import java.time.LocalDate;

public class Booking extends Base{
    private LocalDate BookingDate, BookingStartDate, BookingEndDate;
    private int PeopleCount, ClientId, AgentId, IdPackage, IdDestination;

    public Booking(int id, LocalDate bookingDate, LocalDate bookingStartDate, LocalDate bookingEndDate, int peopleCount, int clientId, int agentId, int idPackage, int idDestination) {
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

    public LocalDate getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        BookingDate = bookingDate;
    }

    public LocalDate getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(LocalDate bookingStartDate) {
        BookingStartDate = bookingStartDate;
    }

    public LocalDate getBookingEndDate() {
        return BookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
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
