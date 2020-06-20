package de.uni.haecksOnTheBeach2020.service;

import de.uni.haecksOnTheBeach2020.domain.StockRequest;
import de.uni.haecksOnTheBeach2020.domain.StockResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static java.time.Duration.ofSeconds;
import static org.springframework.http.HttpMethod.GET;

public class StockService {
    public StockService () {

    }

    public Mono<StockResponse> getResponse (StockRequest request) {
        return buildRequest(request)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StockResponse.class)
                .timeout(ofSeconds(3));
    }

    private WebClient.RequestBodySpec buildRequest (StockRequest request) {
        return WebClient
                .create()
                .method(GET)
                .uri(request.asRequestURI());
    }
}
