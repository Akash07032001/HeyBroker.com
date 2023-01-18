package com.masai.heybroker.model;

import lombok.Data;

//@Data
public class PropertyCriteria {
    private String config;
    private String offer;
    private String city;
    private double minCost;
    private double maxCost;

    public PropertyCriteria() {
    }

    public PropertyCriteria(String config, String offer, String city, double minCost, double maxCost) {
        this.config = config;
        this.offer = offer;
        this.city = city;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getMinCost() {
        return minCost;
    }

    public void setMinCost(double minCost) {
        this.minCost = minCost;
    }

    public double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(double maxCost) {
        this.maxCost = maxCost;
    }

    @Override
    public String toString() {
        return "PropertyCriteria{" +
                "config='" + config + '\'' +
                ", offer='" + offer + '\'' +
                ", city='" + city + '\'' +
                ", minCost=" + minCost +
                ", maxCost=" + maxCost +
                '}';
    }
}
