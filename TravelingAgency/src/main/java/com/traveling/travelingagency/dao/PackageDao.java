package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Package;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PackageDao implements DaoInterf {

    private final DbConnection con;

    @Autowired
    public PackageDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }

    @Override
    public void create(Base model) {
        Package pack = (Package)model;
        String query = "INSERT INTO Package (id_package, description, price, id_service) VALUES (?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, pack.getId());
            st.setString(2, pack.getDescription());
            st.setDouble(3, pack.getPrice());
            st.setInt(4, pack.getIdService());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    /*
    *     private String Description;
    private Double Price;
    private int IdService; // Could work better as an intermediate class
    * */
    @Override
    public void update(Base model) {
    Package pack = (Package)model;
    String query = "UPDATE Package SET description = ?, price = ?, id_service = ? WHERE id_package = ?";
    Connection conn = null;
    try {
        conn = con.getConnection();
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(4, pack.getId());
        st.setString(1, pack.getDescription());
        st.setDouble(2, pack.getPrice());
        st.setInt(3, pack.getIdService());
        st.execute();

    } catch (SQLException e){
        e.printStackTrace();;

    }
    }

    @Override
    public Base retrieveById(int id) {
        Package pack = new Package(0);
        String query = "SELECT * FROM Package WHERE Id_Package = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                pack.setId(rs.getInt(1));
                pack.setDescription(rs.getString(2));
                pack.setPrice(rs.getDouble(3));
                pack.setIdService(rs.getInt(4));
            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return pack;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> packages = new ArrayList<>();
        String query = "SELECT * FROM Package";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Package pack = new Package(rs.getInt(1));
                pack.setDescription(rs.getString(2));
                pack.setPrice(rs.getDouble(3));
                pack.setIdService(rs.getInt(4));
                packages.add(pack);
            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return packages;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Package WHERE id_package = ?";
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
