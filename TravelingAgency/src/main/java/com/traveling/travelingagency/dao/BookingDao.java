package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Booking;
import com.traveling.travelingagency.models.Base;
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
        String query = "INSERT INTO Booking ( bookingDate, bookingStartDate, bookingEndDate, peopleCount, clientId, agentId, idPackage, idDestination) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setDate(1, Date.valueOf(booking.getBookingDate()));
            st.setDate(2, Date.valueOf(booking.getBookingStartDate()));
            st.setDate(3, Date.valueOf(booking.getBookingEndDate()));
            st.setInt(4, booking.getPeopleCount());
            st.setInt(5, booking.getClientId());
            st.setInt(6, booking.getAgentId());
            st.setInt(7, booking.getIdPackage());
            st.setInt(8, booking.getIdDestination());

            st.execute();
        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    @Override
    public void update(Base model) {
        Booking booking = (Booking)model;
        String query = "UPDATE Booking SET bookingDate = ?, bookingStartDate = ?, bookingEndDate = ?, peopleCount = ?, clientId = ?, agentId = ?, idPackage = ?, idDestination = ? WHERE id_booking = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setDate(1, Date.valueOf(booking.getBookingDate()));
            st.setDate(2, Date.valueOf(booking.getBookingStartDate()));
            st.setDate(3, Date.valueOf(booking.getBookingEndDate()));
            st.setInt(4, booking.getPeopleCount());
            st.setInt(5, booking.getClientId());
            st.setInt(6, booking.getAgentId());
            st.setInt(7, booking.getIdPackage());
            st.setInt(8, booking.getIdDestination());
            st.setInt(9, booking.getId());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        }
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
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                booking.setId(rs.getInt("id_booking"));
                booking.setBookingDate(rs.getDate("bookingDate").toLocalDate());
                booking.setBookingStartDate(rs.getDate("bookingStartDate").toLocalDate());
                booking.setBookingEndDate(rs.getDate("bookingEndDate").toLocalDate());
                booking.setPeopleCount(rs.getInt("peopleCount"));
                booking.setClientId(rs.getInt("clientId"));
                booking.setAgentId(rs.getInt("agentId"));
                booking.setIdPackage(rs.getInt("idPackage"));
                booking.setIdDestination(rs.getInt("idDestination"));
            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return booking;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Booking booking = new Booking(rs.getInt("id_booking"));
                booking.setBookingDate(rs.getDate("bookingDate").toLocalDate());
                booking.setBookingStartDate(rs.getDate("bookingStartDate").toLocalDate());
                booking.setBookingEndDate(rs.getDate("bookingEndDate").toLocalDate());
                booking.setPeopleCount(rs.getInt("peopleCount"));
                booking.setClientId(rs.getInt("clientId"));
                booking.setAgentId(rs.getInt("agentId"));
                booking.setIdPackage(rs.getInt("idPackage"));
                booking.setIdDestination(rs.getInt("idDestination"));
                bookings.add(booking);
            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return bookings;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Booking WHERE id_booking = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();;
        }
    }



}
