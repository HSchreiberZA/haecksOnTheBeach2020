package de.uni.haecksOnTheBeach2020.presentation;

import de.uni.haecksOnTheBeach2020.domain.Day;
import de.uni.haecksOnTheBeach2020.domain.StockRequest;
import de.uni.haecksOnTheBeach2020.service.StockService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

import static de.uni.haecksOnTheBeach2020.domain.StockRequest.stockRequest;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping
public class Controller {

    private final StockService stockService = new StockService();

    @GetMapping("/stock")
    public Model getCompactStockData(@RequestParam(name="symbol", required=false, defaultValue="AAPL") String symbol, Model model) {
        StockRequest stockRequest = stockRequest("TIME_SERIES_DAILY", symbol, "compact");
        model.addAttribute("stock", stockService.getResponse(stockRequest).block());
        return model;
    }

    @GetMapping("/history")
    public Mono<List<Double>> getCompactStockHistory(@RequestParam(name = "symbol") String symbol) {
        StockRequest stockRequest = stockRequest("TIME_SERIES_DAILY", symbol, "compact");
        return stockService.getResponse(stockRequest).map(
                stockResponse -> stockResponse.timeSeries.values().stream()
                        .map(Day::getHigh)
                        .collect(toList()));
    }
}
