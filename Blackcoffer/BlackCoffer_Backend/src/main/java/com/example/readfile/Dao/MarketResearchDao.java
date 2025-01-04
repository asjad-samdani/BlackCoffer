package com.example.readfile.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.readfile.Entity.MarketResearch;

public interface MarketResearchDao extends CrudRepository<MarketResearch, Long> {

    @Query("SELECT m.region, COUNT(m.region) AS freq FROM MarketResearch m WHERE m.sector = :sector AND m.region <> '' GROUP BY m.region")
    List<Object[]> getRegionFrequencyForManufacturingSector(@Param("sector") String sector);

    @Query("SELECT DISTINCT m.sector FROM MarketResearch m")
    List<String> findDistinctSector();

    @Query("SELECT m.pestle, COUNT(m.pestle) AS freq FROM MarketResearch m GROUP BY m.pestle")
    List<Object[]> findPestleFrequency();

    @Query("SELECT m.topic, m.likelihood FROM MarketResearch m WHERE m.topic <> '' GROUP BY m.topic, m.likelihood")
    List<Object[]> findTopicwiseLikelihood();

    @Query("SELECT m.city, m.relevance, m.intensity FROM MarketResearch m WHERE m.city <> '' GROUP BY m.city, m.relevance, m.intensity")
    List<Object[]> findRelevanceAndIntensityUsingCity();

}
