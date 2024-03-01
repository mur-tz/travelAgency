package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Services;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ServiceDao implements DaoInterf{
    private final DbConnection con;

    @Autowired
    public ServiceDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }
    @Override
    public void create(Base model) {
        Services service = (Services)model;
        String query = "INSERT INTO Service (id_service, priceUSD, serviceName, description) VALUES (?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, service.getId());
            st.setDouble(2, service.getPriceUSD());
            st.setString(3, service.getServiceName());
            st.setString(4, service.getDescription());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    @Override
    public void update(Base model) {
        Services service = (Services)model;
        String query = "UPDATE Service SET priceUSD = ?, serviceName = ?, description = ? WHERE id_service = ?";

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = con.getConnection();
            st = conn.prepareStatement(query);

            st.setDouble(1, service.getPriceUSD());
            st.setString(2, service.getServiceName());
            st.setString(3, service.getDescription());
            st.setInt(4, service.getId());
            st.execute();



        } catch (SQLException e) {
            System.out.println("Error updating service: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Base retrieveById(int id) {
        Services service = new Services(0);
        String query = "SELECT * FROM Service WHERE Id_Service = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();

            if (res.next()){
                service.setId(1);
                service.setPriceUSD(res.getDouble(2));
                service.setServiceName(res.getString(3));
                service.setDescription(res.getString(4));
            }

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return service;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> services = new ArrayList<>();
        String query = "SELECT * FROM Service;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                Services service = new Services(res.getInt(1));
                service.setPriceUSD(res.getDouble(2));
                service.setServiceName(res.getString(3));
                service.setDescription(res.getString(4));
                services.add(service);
            }

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return services;
    }

    @Override
    public void delete(int id) {

        String query = "DELETE FROM Service WHERE Id_Service = ?";
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
