package com.rbc.bbp0.step;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.request.Root;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

class ExchangeRateItemWriterTest {
    @MockBean
    private ExchangeRateItemWriter exchangeRateItemWriter;

    @Test
    void testWrite() throws Exception {
        doNothing().when(exchangeRateItemWriter).write(Mockito.<List<ExchangeRatesRequest>>any());
        exchangeRateItemWriter.write(new ArrayList<>());
        verify(exchangeRateItemWriter).write(Mockito.<List<ExchangeRatesRequest>>any());
    }

    @Test
    void testGetExchangeRateStatus() {
        doNothing().when(exchangeRateItemWriter).getExchangeRateStatus(Mockito.<ExchangeRatesRequest>any());
        exchangeRateItemWriter.getExchangeRateStatus(new ExchangeRatesRequest());
        verify(exchangeRateItemWriter).getExchangeRateStatus(Mockito.<ExchangeRatesRequest>any());
    }

    @Test
    void testGetRequestObject() {
        Root root = new Root();
        when(exchangeRateItemWriter.getRequestObject(Mockito.<ExchangeRatesRequest>any())).thenReturn(root);
        assertSame(root, exchangeRateItemWriter.getRequestObject(new ExchangeRatesRequest()));
        verify(exchangeRateItemWriter).getRequestObject(Mockito.<ExchangeRatesRequest>any());
    }
}

