package com.traveling.travelingagency.dao;


import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class BookingDao implements DaoInterf {

private final DbConnection con;

@Autowired
    public BookingDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }


    @Override
    public void create(Base model) {
        Booking booking = (Booking)model;
        String query = "INSERT INTO Booking (id_booking,bookingDate, bookingStartDate, bookingEndDate, peopleCount, id_Client, id_Agent, id_Package, id_Destination) VALUES (?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, booking.getId());
            st.setDate(2, booking.getBookingDate());
            st.setDate(3, booking.getBookingStartDate());
            st.setDate(4, booking.getBookingEndDate());
            st.setInt(5, booking.getPeopleCount());
            st.setInt(6, booking.getClientId());
            st.setInt(7, booking.getAgentId());
            st.setInt(8, booking.getIdPackage());
            st.setInt(9, booking.getIdDestination());

            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    @Override
    public void update(Base model) {
        Booking booking = (Booking)model;
        System.out.println("Booking created" + booking.getId());

    }

    @Override
    public Base retrieveById(int id) {
    Booking booking = new Booking(0);
    String query = "SELECT * FROM Booking WHERE Id_Booking = ?";
    Connection conn = null;

    try {
        conn = con.getConnection();
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, id);
        ResultSet res = st.executeQuery();

        if (res.next()){
            booking.setId(1);
            booking.setBookingDate(res.getDate(2));
            booking.setBookingStartDate(res.getDate(3));
            booking.setBookingEndDate(res.getDate(4));
            booking.setPeopleCount(res.getInt(5));
            booking.setClientId(res.getInt(6));
            booking.setAgentId(res.getInt(7));
            booking.setIdPackage(res.getInt(8));
            booking.setIdDestination(res.getInt(9));
        }
    } catch (SQLException e){
        e.printStackTrace();

    }
    return booking;
    }


    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                Booking booking = new Booking(res.getInt(1));
                booking.setBookingDate(res.getDate(2));
                booking.setBookingStartDate(res.getDate(3));
                booking.setBookingEndDate(res.getDate(4));
                booking.setPeopleCount(res.getInt(5));
                booking.setClientId(res.getInt(6));
                booking.setAgentId(res.getInt(7));
                booking.setIdPackage(res.getInt(8));
                booking.setIdDestination(res.getInt(9));
                bookings.add(booking);
            }
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();;
        }
        return bookings;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Booking WHERE Id_Booking = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();;
        }

    }
}
