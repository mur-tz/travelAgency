package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Client;
import com.traveling.travelingagency.models.Base;
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
        String query = "INSERT INTO Client (id_client, name, lastName1, lastName2, email, phone, clientIdentification, nationality, gender, zipCode, birthDate, role, password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            st.setString(12, client.getRole());
            st.setString(13, client.getPassword());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            ;
        }
    }

    @Override
    public void update(Base model) {
        Client client = (Client) model;
        String query = "UPDATE Client SET name = ?, lastName1 = ?, lastName2 = ? ,email = ?,phone = ?, clientIdentification = ?, nationality = ?, gender = ?, zipCode = ?, birthDate = ?, role = ?, password = ? WHERE id_client = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, client.getName());
            st.setString(2, client.getLastName1());
            st.setString(3, client.getLastName2());
            st.setString(4, client.getEmail());
            st.setInt(5, client.getPhone());
            st.setString(6, client.getClientIdentification());
            st.setString(7, client.getNationality());
            st.setString(8, client.getGender());
            st.setString(9, client.getZipCode());
            st.setDate(10, Date.valueOf(client.getBirthDate()));
            st.setInt(13, client.getId());
            st.setString(11, client.getRole());
            st.setString(12, client.getPassword());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    @Override
    public Base retrieveById(int id) {
        Client client = new Client(0);
        String query = "SELECT * FROM Client WHERE Id_Client = ?";
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
                client.setPhone(res.getInt(5));
                client.setEmail(res.getString(6));
                client.setClientIdentification(res.getString(7));
                client.setBirthDate(res.getDate(8).toLocalDate());
                client.setNationality(res.getString(9));
                client.setGender(res.getString(10));
                client.setZipCode(res.getString(11));
                client.setRole(res.getString(13));
                client.setPassword(res.getString(12));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return client;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> clients = new ArrayList<>();
        String query = "SELECT * FROM Client;";
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
                client.setPhone(res.getInt(5));
                client.setEmail(res.getString(6));
                client.setClientIdentification(res.getString(7));
                client.setBirthDate(res.getDate(8).toLocalDate());
                client.setNationality(res.getString(9));
                client.setGender(res.getString(10));
                client.setZipCode(res.getString(11));
                client.setRole(res.getString(13));
                client.setPassword(res.getString(12));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Client WHERE Id_Client = ?";
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