package com.rbc.bbp0.step;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.request.Root;
import org.junit.Test;

import org.junit.jupiter.api.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;

public class ExchangeRateReaderTest {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    @BeforeAll
    static void initAll() {
    }
    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("read")
    public void read(){
        try {
            log.info("Starting execution of read");
            ExchangeRatesRequest expectedValue = null;

                String fxRateApiUrlc="";
                String apiUsernamec="";
                String apiPasswordc="";
                WebClient webClientc = null;

                ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                ExchangeRatesRequest actualValue=exchangeratereader.read();
                log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
                    exception.printStackTrace();
                    Assertions.assertFalse(false);
                }
            }

            @Test
            @DisplayName("read Exception")
            public void readException(){
                try {
                    log.info("Starting execution of readException");
                        String fxRateApiUrlc="";
                        String apiUsernamec="";
                        String apiPasswordc="";
                        WebClient webClientc = null;

                        ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                        exchangeratereader.read();
                        Assertions.assertTrue(false);
		} catch (Exception exception) {
                          exception.printStackTrace();
                            Assertions.assertFalse(true);
                        }
                    }

                    @Test
                    @DisplayName("fetchexchangerate Data From Api")
                    public void fetchexchangerateDataFromApi(){
                        try {
                            log.info("Starting execution of fetchexchangerateDataFromApi");
                            ExchangeRatesRequest expectedValue = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            ExchangeRatesRequest actualValue=exchangeratereader.fetchexchangerateDataFromApi();
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Exchange Rate")
                    public void getExchangeRate(){
                        try {
                            log.info("Starting execution of getExchangeRate");
                            ExchangeRatesRequest expectedValue = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            ExchangeRatesRequest actualValue=exchangeratereader.getExchangeRate();
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Json String")
                    public void getJsonString(){
                        try {
                            log.info("Starting execution of getJsonString");
                            String expectedValue="";
                            com.rbc.bbp0.dto.Root root = null;
                            ObjectMapper objectMapper = null;
                            String json="";

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            String actualValue=ExchangeRateReader.getJsonString(root ,objectMapper ,json);
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Exchange Rate Response")
                    public void getExchangeRateResponse(){
                        try {
                            log.info("Starting execution of getExchangeRateResponse");
                            Root expectedValue = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            com.rbc.bbp0.dto.Root actualValue=exchangeratereader.getExchangeRateResponse();
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Exchange Rates Request")
                    public void getExchangeRatesRequest(){
                        try {
                            log.info("Starting execution of getExchangeRatesRequest");
                            ExchangeRatesRequest expectedValue = null;
                            com.rbc.bbp0.dto.Root root = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            ExchangeRatesRequest actualValue=exchangeratereader.getExchangeRatesRequest( root);
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Date Time")
                    public void getDateTime(){
                        try {
                            log.info("Starting execution of getDateTime");
                            String expectedValue="";
                            com.rbc.bbp0.dto.Root root = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            String actualValue=ExchangeRateReader.getDateTime( root);
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Sell Rate")
                    public void getSellRate(){
                        try {
                            log.info("Starting execution of getSellRate");
                            Double expectedValue= Double.valueOf(0);
                            com.rbc.bbp0.dto.Root root = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            Double actualValue=exchangeratereader.getSellRate( root);
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Assertions.assertFalse(false);
                        }
                    }

                    @Test
                    @DisplayName("get Buy Rate")
                    public void getBuyRate(){
                        try {
                            log.info("Starting execution of getBuyRate");
                            Double expectedValue= Double.valueOf(0);
                            com.rbc.bbp0.dto.Root root = null;

                            String fxRateApiUrlc="";
                            String apiUsernamec="";
                            String apiPasswordc="";
                            WebClient webClientc = null;

                            ExchangeRateReader exchangeratereader  =new ExchangeRateReader( fxRateApiUrlc ,apiUsernamec ,apiPasswordc ,webClientc);
                            Double actualValue=exchangeratereader.getBuyRate( root);
                            log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
                            Assertions.assertEquals(expectedValue, actualValue);
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
