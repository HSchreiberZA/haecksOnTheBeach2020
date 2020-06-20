package de.uni.haecksOnTheBeach2020.service;

import de.uni.haecksOnTheBeach2020.domain.ExpectedArrivalsRequest;
import de.uni.haecksOnTheBeach2020.domain.ExpectedArrivalsResponse;
import org.testng.annotations.Test;

import static de.uni.haecksOnTheBeach2020.domain.ExpectedArrivalsRequest.expectedArrivalsRequest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarineTrafficServiceTest {
    @Test
    public void shouldGetResponse() {
        //given
        int timestamp = 2;
        int shiptype = 7;
        String portid = "172";

        ExpectedArrivalsRequest request = expectedArrivalsRequest(timestamp, portid, shiptype);

        //when
        ExpectedArrivalsResponse response = new MarineTrafficService().getResponse(request);

        //then
        assertThat(response, is(null));
    }
}