package de.uni.haecksOnTheBeach2020.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class StockResponse {
    @JsonProperty("Meta Data")
    public MetaData metaData;
    @JsonProperty("Time Series (Daily)")
    public HashMap<String, Day> timeSeries;

    public StockResponse() {

    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public HashMap<String, Day> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(HashMap<String, Day> timeSeries) {
        this.timeSeries = timeSeries;
    }

    @Override
    public String toString() {
        return "StockResponse2{" +
                "metaData=" + metaData +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
