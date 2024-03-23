package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Client;
import com.traveling.travelingagency.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class DestinationDao implements DaoInterf{
    private final DbConnection con;

    @Autowired
    public DestinationDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }
    @Override
    public void create(Base model) {
        Destination destination = (Destination) model;
        String query = "INSERT INTO Destination (id_destination, airport, city, country) VALUES (?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, destination.getId());
            st.setString(2, destination.getAirport());
            st.setString(3, destination.getCity());
            st.setString(4, destination.getCountry());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Base model) {
        Destination destination = (Destination) model;
        String query = "UPDATE Destination SET airport = ?, city = ?, country = ? WHERE id_destination = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(4, destination.getId());
            st.setString(1, destination.getAirport());
            st.setString(2, destination.getCity());
            st.setString(3, destination.getCountry());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Base retrieveById(int id) {
        Destination dest = new Destination(0);
        String query = "SELECT * FROM Destination WHERE Id_destination = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();

            if (res.next()) {
                dest.setId(1);
                dest.setCountry(res.getString(2));
                dest.setCity(res.getString(3));
                dest.setAirport(res.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return dest;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> dest = new ArrayList<>();
        String query = "SELECT * FROM Destination;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()) {
                Destination destin = new Destination(res.getInt(1));
                destin.setCountry(res.getString(2));
                destin.setCity(res.getString(3));
                destin.setAirport(res.getString(4));

                dest.add(destin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dest;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Destination WHERE id_destination = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
