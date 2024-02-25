package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AgentDao implements DaoInterf{
    private final DbConnection con;

    @Autowired
    public AgentDao(DbConnection dbConnection) {
        this.con = dbConnection;
    }
    @Override
    public void create(Base model) {
        Agent agent = (Agent)model;
        String query = "INSERT INTO agent (id_agent, name, lastName1, lastName2) VALUES (?,?,?,?)";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, agent.getId());
            st.setString(2, agent.getName());
            st.setString(3, agent.getLastName1());
            st.setString(4, agent.getLastName2());
            st.execute();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();;
        }
    }

    @Override
    public void update(Base model) {
        Agent agent = (Agent)model;
        System.out.println("Agent created" + agent.getId());
    }

    @Override
    public Base retrieveById(int id) {
        Agent agent = new Agent(0);
        String query = "SELECT * FROM agent WHERE Id_Agent = ?";
        Connection conn = null;
        try {
            conn = con.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();

            if (res.next()){
                agent.setId(1);
                agent.setName(res.getString(2));
                agent.setLastName1(res.getString(3));
                agent.setLastName2(res.getString(4));
            }
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return agent;
    }

    @Override
    public ArrayList<Base> retrieveAll() {
        ArrayList<Base> agents = new ArrayList<>();
        String query = "SELECT * FROM agent;";
        Connection conn = null;
        try {
            conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                Agent agent = new Agent(res.getInt(1));
                agent.setName(res.getString(2));
                agent.setLastName1(res.getString(3));
                agent.setLastName2(res.getString(4));
                agents.add(agent);
            }
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return agents;
    }

    @Override
    public void delete(int id) {

        String query = "DELETE FROM agent WHERE Id_Agent = ?";
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
