package de.uni.haecksOnTheBeach2020.service;

/*
https://services.marinetraffic.com/api/expectedarrivals/v:3/
8205c862d0572op1655989d939f1496c092ksvs4/
timespan:2/
country:US/
shiptype:7/
protocol:json
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import de.uni.haecksOnTheBeach2020.domain.ExpectedArrivalsRequest;
import de.uni.haecksOnTheBeach2020.domain.ExpectedArrivalsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpMethod.GET;

@Service
public class MarineTrafficService {
    private ObjectMapper objectMapper = new ObjectMapper();

    public MarineTrafficService marineTrafficService(){
        return this;
    }

    public ExpectedArrivalsResponse getResponse (ExpectedArrivalsRequest request) {
        return buildRequest(request).retrieve()
                .bodyToMono(ExpectedArrivalsResponse.class)
                .block();
    }

    public WebClient.RequestBodySpec buildRequest (ExpectedArrivalsRequest expectedArrivalsRequest) {
        return WebClient
                .create()
                .method(GET)
                .uri(expectedArrivalsRequest.asRequestURI());
    }

}
