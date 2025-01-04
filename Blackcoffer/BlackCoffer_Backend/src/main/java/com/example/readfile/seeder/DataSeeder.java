package com.example.readfile.seeder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.readfile.Dao.MarketResearchDao;
import com.example.readfile.Dto.MarketResearchDto;
import com.example.readfile.Entity.MarketResearch;
import com.example.readfile.utils.MyFile;
import com.mysql.cj.exceptions.DataConversionException;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    MarketResearchDao marketDao;

    @Override
    public void run(String... args) throws Exception {
        MyFile myfile = new MyFile(
                "BlackCoffer_Backend\\src\\main\\resources\\static\\Data.csv");
        List<MarketResearchDto> list = myfile.read();

        seedToDB(list);
    }

    public void seedToDB(List<MarketResearchDto> list) {

        List<MarketResearch> mrs = new ArrayList<>();

        for (MarketResearchDto marketResearchDto : list) {
            MarketResearch mr = marketResearchDto.ToEntity();
            mrs.add(mr);
        }

        try {
            marketDao.saveAll(mrs);
        } catch (Exception e) {
            throw new DataConversionException(e.getMessage());
        }
    }
}
