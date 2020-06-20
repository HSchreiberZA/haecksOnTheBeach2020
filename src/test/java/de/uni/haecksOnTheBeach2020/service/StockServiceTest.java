package de.uni.haecksOnTheBeach2020.service;

import de.uni.haecksOnTheBeach2020.domain.StockResponse;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StockServiceTest {

    @Test
    public void testName() {
        StockService stockService = new StockService();
        StockResponse stockResponse = stockService.getStockResponse("AMKAF");

        assertThat(stockResponse.price(), is(1121.0));
    }
}