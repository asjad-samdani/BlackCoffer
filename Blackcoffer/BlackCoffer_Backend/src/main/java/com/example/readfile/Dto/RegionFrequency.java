package com.example.readfile.Dto;

public class RegionFrequency {
    private String region;
    private Integer frequency;

    public RegionFrequency(String region, Integer frequency) {
        this.region = region;
        this.frequency = frequency;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
