package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Trip;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class TripDao implements DaoInterf{
    private final DbConnection con;

    @Autowired
    public TripDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }
    @Override
    public void create(Base model) {
        Trip trip = (Trip)model;
        String query = "INSERT INTO Trip (id_trip, arrivalDate, departureDate,Fk_Destination_id) VALUES (?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, trip.getId());
            st.setDate(2, trip.getArrivalDate());
            st.setDate(3, trip.getDepartureDate());
            st.setInt(4, trip.getFkDestinationId());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        } /* finally {
        // Es una buena práctica cerrar los recursos de la base de datos en un bloque finally
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
    }

    @Override
    public void update(Base model) {
        Trip trip = (Trip)model;
        System.out.println("Trip created" + trip.getId());
    }

    @Override
    public Base retrieveById(int id) {
        Trip trip = new Trip(0);
        String query = "SELECT * FROM Trip WHERE Id_Trip = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();

            if (res.next()){
                trip.setId(1);
                trip.setArrivalDate(res.getDate(2));
                trip.setDepartureDate(res.getDate(3));
            }

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return trip;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> trips = new ArrayList<>();
        String query = "SELECT * FROM Trip;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                Trip trip = new Trip(res.getInt(1));
                trip.setArrivalDate(res.getDate(2));
                trip.setDepartureDate(res.getDate(3));
                trips.add(trip);
            }

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return trips;
    }

    @Override
    public void delete(int id) {

        String query = "DELETE FROM Trip WHERE Id_Trip = ?";
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
