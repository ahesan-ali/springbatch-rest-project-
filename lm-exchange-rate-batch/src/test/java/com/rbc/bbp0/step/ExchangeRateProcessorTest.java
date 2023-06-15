package com.rbc.bbp0.step;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ExchangeRateProcessor.class})
@ExtendWith(SpringExtension.class)
class ExchangeRateProcessorTest {
    @Autowired
    private ExchangeRateProcessor exchangeRateProcessor;

    @Test
    void testProcess() {
        ExchangeRatesRequest exchangeRate = new ExchangeRatesRequest();
        assertSame(exchangeRate, exchangeRateProcessor.process(exchangeRate));
    }

    @Test
    void testProcess2() {
        ExchangeRatesRequest exchangeRate = mock(ExchangeRatesRequest.class);
        assertSame(exchangeRate, exchangeRateProcessor.process(exchangeRate));
    }
}

