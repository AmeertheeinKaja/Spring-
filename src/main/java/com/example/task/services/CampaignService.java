/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.services;

import com.example.task.model.Campaign;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CampaignService {

    private final JdbcTemplate jdbcTemplate;

    public CampaignService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getAll(String clientId) {
        System.err.println("Query 1 : SELECT * FROM " + clientId + ".ctclient");
        String sql = "SELECT * FROM test1.ctclient";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {

            String schema = resultSet.getString("schema");
            System.err.println("Schema:::" + schema);
            return schema;
        });
    }

    public List<Campaign> getAllCampaigns(String clientId) {
        System.out.println("Client::" + clientId);
        List<String> a = getAll(clientId);

//String schemaValue = clientId; 
        String sql = "SELECT * FROM " + clientId + ".campaigns";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {

            Campaign campaign = new Campaign();
            campaign.setId(resultSet.getInt("campaign_id"));
            campaign.setName(resultSet.getString("campaign_name"));
            campaign.setPhoneNumber(resultSet.getString("phone_number"));

            //String schema = resultSet.getString("phone_number");
            return campaign;
        });

    }

}
