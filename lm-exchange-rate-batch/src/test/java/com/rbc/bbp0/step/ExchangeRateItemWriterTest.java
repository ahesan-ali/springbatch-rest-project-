package com.rbc.bbp0.step;
import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.request.Root;
import org.junit.Test;

import org.junit.jupiter.api.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.logging.Logger;

public class ExchangeRateItemWriterTest {

    private Logger log = Logger.getLogger(String.valueOf(ExchangeRateItemWriterTest.class));
    @BeforeAll
    static void initAll() {
    }
    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("write Exception")
    public void writeException(){
        try {
            log.info("Starting execution of writeException");
            List<? extends ExchangeRatesRequest> list = null;

            String exchangeRatePostApic="";
            WebClient webClientc = null;

            ExchangeRateItemWriter exchangerateitemwriter  =new ExchangeRateItemWriter( exchangeRatePostApic ,webClientc);
            exchangerateitemwriter.write( list);
            Assertions.assertTrue(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(true);
        }
    }

    @Test
    @DisplayName("write")
    public void write(){
        try {
            log.info("Starting execution of write");
            List<? extends ExchangeRatesRequest> list = null;

            String exchangeRatePostApic="";
            WebClient webClientc = null;

            ExchangeRateItemWriter exchangerateitemwriter  =new ExchangeRateItemWriter( exchangeRatePostApic ,webClientc);
            exchangerateitemwriter.write( list);
            Assertions.assertTrue(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    @Test
    @DisplayName("get Exchange Rate Status")
    public void getExchangeRateStatus(){
        try {
            log.info("Starting execution of getExchangeRateStatus");
            ExchangeRatesRequest exchangeRate = null;

            String exchangeRatePostApic="";
            WebClient webClientc = null;

            ExchangeRateItemWriter exchangerateitemwriter  =new ExchangeRateItemWriter( exchangeRatePostApic ,webClientc);
            exchangerateitemwriter.getExchangeRateStatus( exchangeRate);
            Assertions.assertTrue(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    @Test
    @DisplayName("get Request Object")
    public void getRequestObject(){
        try {
            log.info("Starting execution of getRequestObject");
            Root expectedValue = null;
            ExchangeRatesRequest exchangeRate = null;

            String exchangeRatePostApic="";
            WebClient webClientc = null;

            ExchangeRateItemWriter exchangerateitemwriter  =new ExchangeRateItemWriter( exchangeRatePostApic ,webClientc);
            Root actualValue=exchangerateitemwriter.getRequestObject( exchangeRate);
            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
            Assertions.assertNotEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.assertFalse(false);
        }
    }
    @AfterEach
    void tearDown() {
    }
    @AfterAll
    static void tearDownAll() {
    }
}
