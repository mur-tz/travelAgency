package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.AgentDao;
import com.traveling.travelingagency.dao.BookingDao;
import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
@Service
public class BookingService implements Services{
    @Autowired
    private BookingDao bookingDao;
    @Override
    public void create(Base model) {
        Booking booking = (Booking)model;
        if (booking.getBookingDate() == null & booking.getBookingStartDate() == null & booking.getBookingEndDate() == null){
            throw new IllegalArgumentException("Debe tener fechas de reservación");
        }
        bookingDao.create(booking);

    }

    @Override
    public void update(Base model) {
        System.out.println(model.getId());
    }

    @Override
    public Base retrieveById(int id) {
        return bookingDao.retrieveById(id);
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        return bookingDao.retrieveAll();
    }

    @Override
    public void delete(int id){
        bookingDao.delete(id);
    }


}
