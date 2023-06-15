package com.rbc.bbp0.step;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ExchangeRateProcessor implements ItemProcessor<ExchangeRatesRequest, ExchangeRatesRequest> {
    @Override
    public ExchangeRatesRequest process(ExchangeRatesRequest exchangeRate) {
        log.info("Processing the Exchange Rate Data: ");
        return exchangeRate;
    }
}
