package de.uni.haecksOnTheBeach2020.domain;

import java.net.URI;

import static java.lang.String.format;
import static java.net.URI.create;

public class StockRequest {
    private static final String endpoint = "https://www.alphavantage.co/query?";
    private final String function;
    private final String symbol;
    private final String outputSize;
    private static final String apiKey = "TRHGQN6J5J8SE4B6";

    private StockRequest (String function, String symbol, String outputSize) {
        this.function = function;
        this.symbol = symbol;
        this.outputSize = outputSize;
    }

    public static StockRequest stockRequest (String function, String symbol, String outputSize) {
        return new StockRequest(function, symbol, outputSize);
    }

    public URI asRequestURI () {
        return create(format(endpoint + "function=%s&symbol=%s&outputsize=%s&apikey=" + apiKey, function, symbol, outputSize));
    }

}
