package de.uni.haecksOnTheBeach2020.domain;

import java.net.URI;

import static java.net.URI.create;

public class ExpectedArrivalsRequest {
    private static final String endpoint = "https://services.marinetraffic.com/api/expectedarrivals/v:3/";
    private static final String APIkey = "e42b18ed00b68087343cd4d63ff9e5f4bfae3172";

    private int timespan;
    private String portid;
    private int shiptype;

    private ExpectedArrivalsRequest (int timespan, String portid, int shiptype) {
        this.timespan = timespan;
        this.portid = portid;
        this.shiptype = shiptype;
    }

    public static ExpectedArrivalsRequest expectedArrivalsRequest (int timespan, String portid, int shiptype) {
        return new ExpectedArrivalsRequest(timespan, portid, shiptype);
    }

    public URI asRequestURI () {
        return create(String.format(endpoint + APIkey + "/timespan:%d/portid:%s/shiptype:%d/protocol:json", timespan, portid, shiptype));
    }

}
