package com.traveling.travelingagency.dao;


import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
@Repository
public class ClientDao implements DaoInterf {
    private final DbConnection con;

    @Autowired
    public ClientDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }

    @Override
    public void create(Base model) {
        Client client = (Client) model;
        String query = "INSERT INTO client (id_client, name, lastName1, lastName2, email, phone, clientIdentification, nationality, gender, zipCode, birthDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, client.getId());
            st.setString(2, client.getName());
            st.setString(3, client.getLastName1());
            st.setString(4, client.getLastName2());
            st.setString(5, client.getEmail());
            st.setInt(6, client.getPhone());
            st.setString(7, client.getClientIdentification());
            st.setString(8, client.getNationality());
            st.setString(9, client.getGender());
            st.setString(10, client.getZipCode());
            st.setDate(11, Date.valueOf(client.getBirthDate()));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            ;
        }
    }

    @Override
    public void update(Base model) {
        Client client = (Client) model;
        System.out.println("Client created" + client.getId());
    }

    @Override
    public Base retrieveById(int id) {
        Client client = new Client(0);
        String query = "SELECT * FROM client WHERE Id_Client = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();

            if (res.next()) {
                client.setId(1);
                client.setName(res.getString(2));
                client.setLastName1(res.getString(3));
                client.setLastName2(res.getString(4));
                client.setEmail(res.getString(5));
                client.setPhone(res.getInt(6));
                client.setClientIdentification(res.getString(7));
                client.setNationality(res.getString(8));
                client.setGender(res.getString(9));
                client.setZipCode(res.getString(10));
                client.setBirthDate(res.getDate(11).toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return client;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> clients = new ArrayList<>();
        String query = "SELECT * FROM client;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()) {
                Client client = new Client(res.getInt(1));
                client.setName(res.getString(2));
                client.setLastName1(res.getString(3));
                client.setLastName2(res.getString(4));
                client.setEmail(res.getString(5));
                client.setPhone(res.getInt(6));
                client.setClientIdentification(res.getString(7));
                client.setNationality(res.getString(8));
                client.setGender(res.getString(9));
                client.setZipCode(res.getString(10));
                client.setBirthDate(res.getDate(11).toLocalDate());
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM client WHERE Id_Client = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
