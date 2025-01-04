package com.example.readfile.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.readfile.Service.MarketService;

@RestController
public class MarketController {
    @Autowired
    private MarketService marketService;

    @CrossOrigin
    @GetMapping("/market-research")
    public Object getMethodName() {
        return marketService.GetAllMarketResearchData();
    }

    @CrossOrigin
    @GetMapping("/query")
    public Object getMarketResearch(@RequestParam String sector) {
        return marketService.getMarketResearchBySector(sector);
    }

    @CrossOrigin
    @GetMapping("/sector")
    public Object getMarketsearchSector() {
        return marketService.getUniqueSectorData();
    }

    @CrossOrigin
    @GetMapping("/pestle-frequency")
    public Map<String, Long> getPestleFrequency() {
        return marketService.getPestleFrequency();
    }

    @CrossOrigin
    @GetMapping("/topic")
    public Map<String, Long> getTopicData() {
        return marketService.getTopicsWiseLikelihood();
    }

    @CrossOrigin
    @GetMapping("/city")
    public List<Map<String, Object>> getCityData() {
        return marketService.getRelevanceAndIntensityByCity();
    }

}
