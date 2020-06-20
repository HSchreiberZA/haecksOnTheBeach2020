package de.uni.haecksOnTheBeach2020.presentation;

import de.uni.haecksOnTheBeach2020.domain.StockRequest;
import de.uni.haecksOnTheBeach2020.domain.StockResponse;
import de.uni.haecksOnTheBeach2020.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static de.uni.haecksOnTheBeach2020.domain.StockRequest.stockRequest;

@RestController
@RequestMapping(value = "/stock")
public class Controller {

    private StockService stockService = new StockService();

    @GetMapping
    public Mono<StockResponse> getTestData(String symbol) {
        StockRequest stockRequest = stockRequest("TIME_SERIES_DAILY", symbol, "COMPACT");
        return stockService.getResponse(stockRequest);
    }
}
