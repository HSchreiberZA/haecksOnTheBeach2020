package de.uni.haecksOnTheBeach2020.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

import static de.uni.haecksOnTheBeach2020.domain.MetaData.emptyMetaData;

public class StockResponse {
    @JsonProperty("Meta Data")
    public MetaData meta;
    @JsonProperty("Time Series (Daily)")
    public HashMap<String, Day> timeSeries;

    public static final StockResponse emptyStockResponse = new StockResponse(emptyMetaData, new HashMap<>());
    public StockResponse() {

    }

    private StockResponse(MetaData metaData, HashMap<String, Day> timeSeries) {
        this.meta = metaData;
        this.timeSeries = timeSeries;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public HashMap<String, Day> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(HashMap<String, Day> timeSeries) {
        this.timeSeries = timeSeries;
    }

    public double getOpen () {
        return timeSeries.entrySet().stream()
                .findFirst()
                .map(entry -> entry.getValue().getHigh())
                .orElse(0d);
    }

    public double getClose () {
        return timeSeries.entrySet().stream()
                .findFirst()
                .map(entry -> entry.getValue().getLow())
                .orElse(0d);
    }

    @Override
    public String toString() {
        return "StockResponse{" +
                "meta=" + meta +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
