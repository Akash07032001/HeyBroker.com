package com.masai.heybroker.model;

import java.util.List;

public class Broker {

    private Integer brokerId;
    private Integer brokerName;
    private List<Property> properties;

    public Broker() {
    }

    public Broker(Integer brokerId, Integer brokerName, List<Property> properties) {
        this.brokerId = brokerId;
        this.brokerName = brokerName;
        this.properties = properties;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(Integer brokerName) {
        this.brokerName = brokerName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
