package de.uni.haecksOnTheBeach2020.domain;

import org.testng.annotations.Test;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExpectedArrivalsRequestTest {

    @Test
    public void shouldCreateRequest() {
        //given
        int timestamp = 2;
        int shiptype = 7;
        String portid = "DEHAM";

        URI expectedArrivalsRequest = ExpectedArrivalsRequest.expectedArrivalsRequest(timestamp, portid, shiptype).asRequestURI();
        assertThat(expectedArrivalsRequest, is(URI.create("https://services.marinetraffic.com/api/expectedarrivals/v:3/e42b18ed00b68087343cd4d63ff9e5f4bfae3172/timespan:2/portid:DEHAM/shiptype:7/protocol:json")));
    }
}