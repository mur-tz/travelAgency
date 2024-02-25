package com.traveling.travelingagency.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbConnection {
    private static DbConnection instance;
    private Connection connection;
    public DbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3305/componentes",user= "root", password = "root";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance(){
        if (instance == null){
            instance = new DbConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
