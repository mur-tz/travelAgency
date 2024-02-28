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
            String url = "jdbc:mysql://45.88.196.5:3306/u484426513_grupo1diseno?user=u484426513_grupo1diseno&password=Grupo1diseno!";
            connection = DriverManager.getConnection(url);
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
