package com.example.readfile.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.readfile.Dto.MarketResearchDto;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class MyFile {

    private String FilePath;

    public MyFile(String path) {
        this.FilePath = path;
    }

    public List<MarketResearchDto> read() {
        File input = new File(this.FilePath);
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE);
        CsvSchema bootstrapSchema = CsvSchema.builder()
                .setUseHeader(true)
                .addColumn("end_year", CsvSchema.ColumnType.NUMBER)
                .addColumn("citylng", CsvSchema.ColumnType.STRING_OR_LITERAL)
                .addColumn("citylat", CsvSchema.ColumnType.STRING)
                .addColumn("intensity", CsvSchema.ColumnType.NUMBER)
                .addColumn("sector", CsvSchema.ColumnType.STRING)
                .addColumn("topic", CsvSchema.ColumnType.STRING)
                .addColumn("insight", CsvSchema.ColumnType.STRING)
                .addColumn("swot", CsvSchema.ColumnType.STRING)
                .addColumn("url", CsvSchema.ColumnType.STRING)
                .addColumn("region", CsvSchema.ColumnType.STRING)
                .addColumn("start_year", CsvSchema.ColumnType.NUMBER)
                .addColumn("impact", CsvSchema.ColumnType.STRING)
                .addColumn("added", CsvSchema.ColumnType.STRING)
                .addColumn("published", CsvSchema.ColumnType.STRING)
                .addColumn("city", CsvSchema.ColumnType.STRING)
                .addColumn("country", CsvSchema.ColumnType.STRING)
                .addColumn("relevance", CsvSchema.ColumnType.NUMBER)
                .addColumn("pestle", CsvSchema.ColumnType.STRING)
                .addColumn("source", CsvSchema.ColumnType.STRING)
                .addColumn("title", CsvSchema.ColumnType.STRING)
                .addColumn("likelihood", CsvSchema.ColumnType.NUMBER)
                .build();

        List<MarketResearchDto> list = new ArrayList<>();
        int counter = 0;
        try {

            MappingIterator<MarketResearchDto> mappingIterator = csvMapper.readerFor(MarketResearchDto.class)
                    .with(bootstrapSchema)
                    .readValues(input);

            while (mappingIterator.hasNextValue()) {
                list.add(mappingIterator.nextValue());
                counter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("processed rows: " + counter);
            return list;
        }

        return list;
    }

}
