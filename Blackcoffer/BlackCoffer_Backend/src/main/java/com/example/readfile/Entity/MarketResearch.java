package com.example.readfile.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "market_research")
public class MarketResearch extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer Id;
    public Integer end_year;
    public String citylng;
    public String citylat;
    public Integer intensity;
    public String sector;
    public String topic;
    @Column(columnDefinition = "TEXT")
    public String insight;
    public String swot;
    public String url;
    public String region;
    public Integer start_year;
    public String impact;
    public String added;
    public String published;
    public String city;
    public String country;
    public Integer relevance;
    public String pestle;
    public String source;
    @Column(columnDefinition = "TEXT")
    public String title;
    public Integer likelihood;

    public MarketResearch(String city2, Long relevance2, Long intensity2) {
        super();
    }

    public MarketResearch(Integer end_year, String citylng, String citylat, Integer intensity,
            String sector,
            String topic,
            String insight, String swot, String url, String region, Integer start_year, String impact, String added,
            String published, String city, String country, Integer relevance, String pestle, String source,
            String title,
            Integer likelihood) {
        this.end_year = end_year;
        this.citylng = citylng;
        this.citylat = citylat;
        this.intensity = intensity;
        this.sector = sector;
        this.topic = topic;
        this.insight = insight;
        this.swot = swot;
        this.url = url;
        this.region = region;
        this.start_year = start_year;
        this.impact = impact;
        this.added = added;
        this.published = published;
        this.city = city;
        this.country = country;
        this.relevance = relevance;
        this.pestle = pestle;
        this.source = source;
        this.title = title;
        this.likelihood = likelihood;
    }

    public Integer getEnd_year() {
        return end_year;
    }

    public void setEnd_year(Integer end_year) {
        this.end_year = end_year;
    }

    public String getCitylng() {
        return citylng;
    }

    public void setCitylng(String citylng) {
        this.citylng = citylng;
    }

    public String getCitylat() {
        return citylat;
    }

    public void setCitylat(String citylat) {
        this.citylat = citylat;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInsight() {
        return insight;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

    public String getSwot() {
        return swot;
    }

    public void setSwot(String swot) {
        this.swot = swot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getStart_year() {
        return start_year;
    }

    public void setStart_year(Integer start_year) {
        this.start_year = start_year;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public String getPestle() {
        return pestle;
    }

    public void setPestle(String pestle) {
        this.pestle = pestle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(Integer likelihood) {
        this.likelihood = likelihood;
    }

    @Override
    public String toString() {
        return "Root [end_year=" + end_year + ", citylng=" + citylng + ", citylat=" + citylat + ", intensity="
                + intensity + ", sector=" + sector + ", topic=" + topic + ", insight=" + insight + ", swot=" + swot
                + ", url=" + url + ", region=" + region + ", start_year=" + start_year + ", impact=" + impact
                + ", added=" + added + ", published=" + published + ", city=" + city + ", country=" + country
                + ", relevance=" + relevance + ", pestle=" + pestle + ", source=" + source + ", title=" + title
                + ", likelihood=" + likelihood + ", getClass()=" + getClass() + ", getEnd_year()=" + getEnd_year()
                + ", getCitylng()=" + getCitylng() + ", getCitylat()=" + getCitylat() + ", getIntensity()="
                + getIntensity() + ", getSector()=" + getSector() + ", getTopic()=" + getTopic() + ", getInsight()="
                + getInsight() + ", getSwot()=" + getSwot() + ", getUrl()=" + getUrl() + ", getRegion()=" + getRegion()
                + ", hashCode()=" + hashCode() + ", getStart_year()=" + getStart_year() + ", getImpact()=" + getImpact()
                + ", getAdded()=" + getAdded() + ", getPublished()=" + getPublished() + ", getCity()=" + getCity()
                + ", getCountry()=" + getCountry() + ", getRelevance()=" + getRelevance() + ", getPestle()="
                + getPestle() + ", getSource()=" + getSource() + ", getTitle()=" + getTitle() + ", getLikelihood()="
                + getLikelihood() + ", toString()=" + super.toString() + "]";
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

}
