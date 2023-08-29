/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.task.controller;

import com.example.task.model.Campaign;
import com.example.task.services.CampaignService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

//    @GetMapping("/campaigns")
//    public List<Campaign> getCampaigns() {
//        return campaignService.getAllCampaigns();
//    }
    @GetMapping("/{ctClient}")
    public List<Campaign> getCampaigns1(@PathVariable("ctClient") String ctClient) {
        return campaignService.getAllCampaigns(ctClient);
    }
    
    @GetMapping
    public List<Campaign> getCampaigns(@RequestParam String ctClient) {
        return campaignService.getAllCampaigns(ctClient);
    }
}
