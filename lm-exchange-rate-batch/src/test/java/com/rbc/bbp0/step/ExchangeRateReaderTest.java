package com.rbc.bbp0.step;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbc.bbp0.dto.*;
import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.step.ExchangeRateReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ExchangeRateReaderTest {

    @Mock
    private WebClient webClient;

    private ExchangeRateReader exchangeRateReader;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        exchangeRateReader = new ExchangeRateReader(
                "http://example.com/api",
                "username",
                "password",
                webClient
        );
    }

        @Test
        public void testRead_WhenBatchJobStateTrue_ReturnsNull() throws Exception {
            // Arrange
            exchangeRateReader.read(); // Set batchJobState to true

            // Act
            ExchangeRatesRequest result = exchangeRateReader.read();

            // Assert
            assertEquals(null, result);
        }

    @Test
    public void testFetchExchangeRateDataFromApi_ReturnsExchangeRatesRequest() {
        // Arrange
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);
        doReturn(new ExchangeRatesRequest()).when(spyExchangeRateReader).getExchangeRate();

        // Act
        ExchangeRatesRequest result = spyExchangeRateReader.fetchexchangerateDataFromApi();

        // Assert
        verify(spyExchangeRateReader, times(1)).getExchangeRate();
        assertEquals(ExchangeRatesRequest.class, result.getClass());
    }

    @Test
    public void testGetExchangeRate_ReturnsExchangeRatesRequest() {
        // Arrange
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);
        Root root = new Root();
        root.wsImsoArea = new Wsimsoarea();
        root.wsImsoArea.pvrFxInterfaceArea = new PvrFxInterfaceArea();
        root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea = new PvrFxReturnArea();
        root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea = new com.rbc.bbp0.dto.PvrFxRateReturnArea();
        root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray = new java.util.ArrayList<RateReturnDetailArray>();
       // root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0)  = new RateReturnDetailArray();
       // root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail = new RateReturnDetail();
       // root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo = new RetrievedRateInfo();
       // root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rbcSellRate = 1.0;
        //root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rbcBuyRate = 2.0;

        doReturn(root).when(spyExchangeRateReader).getExchangeRateResponse();
        doReturn(new ExchangeRatesRequest()).when(spyExchangeRateReader).getExchangeRatesRequest(any(Root.class));

        // Act
        ExchangeRatesRequest result = spyExchangeRateReader.getExchangeRate();

        // Assert
        verify(spyExchangeRateReader, times(1)).getExchangeRateResponse();
        verify(spyExchangeRateReader, times(1)).getExchangeRatesRequest(any(Root.class));
        assertEquals(ExchangeRatesRequest.class, result.getClass());
    }

    @Test
    public void testGetJsonString_ReturnsJsonString() {
        // Arrange
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);
        Root root = new Root();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        // Act
        String result = spyExchangeRateReader.getJsonString(root, objectMapper, json);
        assertNotNull(result);
        // Assert
       // verify(spyExchangeRateReader, times(1)).getJsonString(root, objectMapper, json);
        assertEquals(String.class, result.getClass());
    }

    /*@Test
    public void testGetExchangeRatesRequest_ReturnsExchangeRatesRequest() {
        // Arrange
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);

         Root root=getRoot();
        String date= String.valueOf(root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rateLastUpdTimestamp.rateLastUpdDate.longValue());
        String time= String.valueOf(root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rateLastUpdTimestamp.rateLastUpdTime.longValue());
        String dateTime=date.concat(time);
        doReturn("20230101").when(spyExchangeRateReader).getDateTime(root);
        doReturn(1.0).when(spyExchangeRateReader).getBuyRate(root);
        doReturn(2.0).when(spyExchangeRateReader).getSellRate(root);

        // Act
        ExchangeRatesRequest result = spyExchangeRateReader.getExchangeRatesRequest(root);

        // Assert
        verify(spyExchangeRateReader, times(1)).getExchangeRatesRequest(root);
        assertEquals(ExchangeRatesRequest.class, result.getClass());
    }*/

    private Root getRoot() {
        //root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rateLastUpdTimestamp.rateLastUpdDate
        //root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rbcBuyRate;
        Root root = new Root();
        Wsimsoarea wsimsoarea=new Wsimsoarea();
        root.setWsImsoArea(wsimsoarea);
        PvrFxInterfaceArea pvrFxInterfaceArea=new PvrFxInterfaceArea();
        wsimsoarea.setPvrFxInterfaceArea(pvrFxInterfaceArea);
        PvrFxReturnArea pvrFxReturnArea=new PvrFxReturnArea();

        PvrFxRateReturnArea pvrFxRateReturnArea=new PvrFxRateReturnArea();

        RateReturnDetailArray rateReturnDetailArray=new RateReturnDetailArray();
        RateReturnDetail rateReturnDetail=new RateReturnDetail();

        RetrievedRateInfo retrievedRateInfo=new RetrievedRateInfo();
        retrievedRateInfo.setRbcBuyRate(0.1);
        retrievedRateInfo.setRbcSellRate(0.1);

        RateLastUpdTimestamp rateLastUpdTimestamp=new RateLastUpdTimestamp();
        rateLastUpdTimestamp.setRateLastUpdTime(0l);
        rateLastUpdTimestamp.setRateLastUpdDate(20230101l);
        retrievedRateInfo.setRateLastUpdTimestamp(rateLastUpdTimestamp);

        rateReturnDetail.setRetrievedRateInfo(retrievedRateInfo);
        rateReturnDetailArray.setRateReturnDetail(rateReturnDetail);
        ArrayList<RateReturnDetailArray> list=new ArrayList<RateReturnDetailArray>();
        list.add(rateReturnDetailArray);
        pvrFxRateReturnArea.setRateReturnDetailArray(list);
        pvrFxReturnArea.setPvrFxRateReturnArea(pvrFxRateReturnArea);
        pvrFxInterfaceArea.setPvrFxReturnArea(pvrFxReturnArea);
        return root;
    }

    @Test
    public void testGetDateTime_ReturnsDateTimeString() {
        // Arrange
        Root root = getRoot();

        // Set up the root object as needed for the test case
        String dateTime=ExchangeRateReader.getDateTime(root);
        assertNotNull(dateTime);
        // Act
    }

    @Test
    public void testGetSellRate_ReturnsSellRate() {
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);
        Root root = getRoot();
        Double seRate=exchangeRateReader.getSellRate(root);
        assertNotNull(seRate);
        Double result = spyExchangeRateReader.getSellRate(root);
        assertEquals(Double.class, result.getClass());
    }

    @Test
    public void testGetBuyRate_ReturnsBuyRate() {
        ExchangeRateReader spyExchangeRateReader = spy(exchangeRateReader);
        Root root = getRoot();
        Double buyRate=exchangeRateReader.getBuyRate(root);
        assertNotNull(buyRate);
        Double result = spyExchangeRateReader.getBuyRate(root);
        verify(spyExchangeRateReader, times(1)).getBuyRate(root);
        assertEquals(Double.class, result.getClass());
    }

}
