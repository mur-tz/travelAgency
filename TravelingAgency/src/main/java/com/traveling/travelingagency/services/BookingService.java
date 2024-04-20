package com.traveling.travelingagency.services;

import com.traveling.travelingagency.dao.BookingDao;
import com.traveling.travelingagency.models.Booking;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingService implements Services {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public void create(Base model) {
        Booking booking = (Booking)model;
        if (booking.getBookingDate() == null) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser nula");
        }
        bookingDao.create(booking);
    }

    @Override
    public void update(Base model) {
        Booking booking = (Booking)model;
        bookingDao.update(booking);
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
    public void delete(int id) {
        bookingDao.delete(id);
    }

}
