package de.uni.haecksOnTheBeach2020.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {
    @JsonProperty("1. open")
    private Double open;
    @JsonProperty("2. high")
    private Double high;
    @JsonProperty("3. low")
    private Double low;
    @JsonProperty("4. volume")
    private Double volume;

    Match () {}

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Match{" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
