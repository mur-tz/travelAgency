package com.traveling.travelingagency.dao;

import com.traveling.travelingagency.models.Agent;
import com.traveling.travelingagency.models.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void Create(Base model) {
        Agent agent = (Agent)model;
        System.out.println("Agent created" + agent.getId());
    }

    @Override
    public void Update(Base model) {
        Agent agent = (Agent)model;
        System.out.println("Agent created" + agent.getId());
    }

    @Override
    public Base RetrieveById(int id) {
        return null;
    }

    @Override
    public ArrayList<Base> RetrieveAll() {
        ArrayList<Base> agents = new ArrayList<>();
        String query = "SELECT * FROM agent;";
        try {
            Connection conn = con.getConnection();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                Agent agent = new Agent(res.getInt(1));
                agent.setName(res.getString(2));
                agent.setLastName1(res.getString(3));
                agent.setLastName2(res.getString(4));
                agents.add(agent);
            }

        } catch (SQLException e){
            e.printStackTrace();;
        }

        return agents;
    }

    @Override
    public void Delete(int id) {
        System.out.println(id);
    }
}
