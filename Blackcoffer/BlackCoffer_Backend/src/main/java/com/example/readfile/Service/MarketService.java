package com.example.readfile.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.readfile.Dao.MarketResearchDao;
import com.example.readfile.Entity.MarketResearch;

@Service
public class MarketService {
    @Autowired
    private MarketResearchDao marketDao;

    public Iterable<MarketResearch> GetAllMarketResearchData() {
        return marketDao.findAll();
    }

    public Object getMarketResearchBySector(String sector) {
        List<Object[]> data = marketDao.getRegionFrequencyForManufacturingSector(sector);
        HashMap<String, Long> datamap = new HashMap<>();
        for (Object[] regionFrequency : data) {
            datamap.put((String) regionFrequency[0], (Long) regionFrequency[1]);
        }

        return datamap;
    }

    public List<String> getUniqueSectorData() {
        return marketDao.findDistinctSector();
    }

    public HashMap<String, Long> getPestleFrequency() {
        List<Object[]> results = marketDao.findPestleFrequency();
        HashMap<String, Long> pestleFrequencyMap = new HashMap<>();
        for (Object[] result : results) {
            if (Objects.equals(result[0], "")) {
                result[0] = "No Impact";
            }

            pestleFrequencyMap.put((String) result[0], (Long) result[1]);
        }
        return pestleFrequencyMap;
    }

    public HashMap<String, Long> getTopicsWiseLikelihood() {
        List<Object[]> likeLihood = marketDao.findTopicwiseLikelihood();
        HashMap<String, Long> topicWiseLikelihood = new HashMap<>();

        for (Object[] topicFrequency : likeLihood) {
            Long likelihood = ((Number) topicFrequency[1]).longValue();
            topicWiseLikelihood.put((String) topicFrequency[0], likelihood);
        }

        return topicWiseLikelihood;
    }

    public List<Map<String, Object>> getRelevanceAndIntensityByCity() {
        List<Object[]> data = marketDao.findRelevanceAndIntensityUsingCity();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] record : data) {
            Map<String, Object> cityData = new HashMap<>();
            cityData.put("city", (String) record[0]);
            cityData.put("relevance", ((Number) record[1]).longValue());
            cityData.put("intensity", ((Number) record[2]).longValue());
            result.add(cityData);
        }

        return result;
    }

}
