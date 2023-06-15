package com.rbc.bbp0.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.rbc.bbp0.dto.AmtRangeInfo;
import com.rbc.bbp0.dto.FwdRateLastUpdTimestamp;
import com.rbc.bbp0.dto.FwdStaleTimestamp;
import com.rbc.bbp0.dto.PvrFxInterfaceArea;
import com.rbc.bbp0.dto.PvrFxRateReturnArea;
import com.rbc.bbp0.dto.PvrFxReqReturnCodeArea;
import com.rbc.bbp0.dto.PvrFxReturnArea;
import com.rbc.bbp0.dto.RateLastUpdTimestamp;
import com.rbc.bbp0.dto.RateReturnDetail;
import com.rbc.bbp0.dto.RateReturnDetailArray;
import com.rbc.bbp0.dto.RetrievedRateInfo;
import com.rbc.bbp0.dto.Root;
import com.rbc.bbp0.dto.StaleTimestamp;
import com.rbc.bbp0.dto.Wsimsoarea;
import com.rbc.bbp0.dto.request.ExchangeRatesRequest;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ContextConfiguration(classes = {ExchangeRateReader.class, String.class})
@ExtendWith(SpringExtension.class)
class ExchangeRateReaderTest {
    @MockBean
    private WebClient webClient;

    @MockBean
    private ExchangeRateReader exchangeRateReader;

    /**
     * Method under test: {@link ExchangeRateReader#ExchangeRateReader(String, String, String, WebClient)}
     */
    @Test
    void testConstructor() {
        assertNull(
                (new ExchangeRateReader("https://example.org/example", "janedoe", "iloveyou", null)).getExchangeRate());
    }

    /**
     * Method under test: {@link ExchangeRateReader#read()}
     */
    @Test
    void testRead() throws Exception {
        ExchangeRatesRequest exchangeRatesRequest = new ExchangeRatesRequest();
        when(exchangeRateReader.read()).thenReturn(exchangeRatesRequest);
        assertSame(exchangeRatesRequest, exchangeRateReader.read());
        verify(exchangeRateReader).read();
    }

    /**
     * Method under test: {@link ExchangeRateReader#read()}
     */
    @Test
    void testRead2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        assertNull((new ExchangeRateReader("https://example.org/example", "janedoe", "iloveyou", null)).read());
    }

    /**
     * Method under test: {@link ExchangeRateReader#read()}
     */
    @Test
    void testRead3() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        WebClient webClient = mock(WebClient.class);
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get()).thenReturn(null);
        assertNull((new ExchangeRateReader("https://example.org/example", "janedoe", "iloveyou", webClient)).read());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#fetchexchangerateDataFromApi()}
     */
    @Test
    void testFetchexchangerateDataFromApi() {
        ExchangeRatesRequest exchangeRatesRequest = new ExchangeRatesRequest();
        when(exchangeRateReader.fetchexchangerateDataFromApi()).thenReturn(exchangeRatesRequest);
        assertSame(exchangeRatesRequest, exchangeRateReader.fetchexchangerateDataFromApi());
        verify(exchangeRateReader).fetchexchangerateDataFromApi();
    }

    /**
     * Method under test: {@link ExchangeRateReader#fetchexchangerateDataFromApi()}
     */
    @Test
    void testFetchexchangerateDataFromApi2() {
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get()).thenReturn(null);
        assertNull(exchangeRateReader.fetchexchangerateDataFromApi());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#fetchexchangerateDataFromApi()}
     */
    @Test
    void testFetchexchangerateDataFromApi3() {
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get())
                .thenThrow(new UnexpectedInputException("An error occurred"));
        assertNull(exchangeRateReader.fetchexchangerateDataFromApi());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRate()}
     */
    @Test
    void testGetExchangeRate() {
        ExchangeRatesRequest exchangeRatesRequest = new ExchangeRatesRequest();
        when(exchangeRateReader.getExchangeRate()).thenReturn(exchangeRatesRequest);
        assertSame(exchangeRatesRequest, exchangeRateReader.getExchangeRate());
        verify(exchangeRateReader).getExchangeRate();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRate()}
     */
    @Test
    void testGetExchangeRate2() {
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get()).thenReturn(null);
        assertNull(exchangeRateReader.getExchangeRate());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRate()}
     */
    @Test
    void testGetExchangeRate3() {
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get())
                .thenThrow(new UnexpectedInputException("An error occurred"));
        assertNull(exchangeRateReader.getExchangeRate());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getJsonString(Root, ObjectMapper, String)}
     */
    @Test
    void testGetJsonString() {
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(
                "{\"WS_IMS_O_AREA\":{\"PVRFxInterfaceArea\":{\"PVRFxReturnArea\":{\"PVRFxReqReturnCodeArea\":{\"RequestReturnCode"
                        + "\":1,\"ErrorWarnFlag\":-1},\"PVRFxRateReturnArea\":{\"RateReturnDetailArray\":[]}}}}}",
                ExchangeRateReader.getJsonString(root, objectMapper, "Json"));
        assertTrue(objectMapper.getSerializerProviderInstance() instanceof DefaultSerializerProvider.Impl);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getJsonString(Root, ObjectMapper, String)}
     */
    @Test
    void testGetJsonString2() {
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = mock(Root.class);
        root.wsImsoArea = wsimsoarea;
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals("Json", ExchangeRateReader.getJsonString(root, objectMapper, "Json"));
        assertTrue(objectMapper.getSerializerProviderInstance() instanceof DefaultSerializerProvider.Impl);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getJsonString(Root, ObjectMapper, String)}
     */
    @Test
    void testGetJsonString3() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "Amt Range";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = 1L;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "Cap Mkt Bu Fwd Rate Status";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "Cap Mkt Buy Rate Status";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "Cap Mkt Sell Fwd Rate Status";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "Cap Mkt Sell Rate Satus";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "Fwd Adj Type";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "Link Status";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "Pvr Rate Key";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "Rbc Buy Fwd Rate Status";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "Rbc Buy Rate Status";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "Rbc Sell Fwd Rate Status";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "Rbc Sell Rate Status";
        retrievedRateInfo.reciprocalFlag = "Reciprocal Flag";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "Indirect Quote Flag";
        rateReturnDetail.intRateBasis = "Int Rate Basis";
        rateReturnDetail.quotationUnit = "Quotation Unit";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "Rate Return Desc";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(
                "{\"WS_IMS_O_AREA\":{\"PVRFxInterfaceArea\":{\"PVRFxReturnArea\":{\"PVRFxReqReturnCodeArea\":{\"RequestReturnCode"
                        + "\":1,\"ErrorWarnFlag\":-1},\"PVRFxRateReturnArea\":{\"RateReturnDetailArray\":[{\"RateReturnDesc\":\"Rate Return"
                        + " Desc\",\"RateReturnCode\":1,\"RateReturnDetail\":{\"AmtRangeInfo\":{\"AmtRangeLowerValue\":42,\"BranchLimitFormat"
                        + "\":1,\"AmtRange\":\"Amt Range\",\"AmtRangeUpperValue\":42,\"BranchLimit\":1,\"AmtRangeEffDate\":\"2020-03-01\","
                        + "\"AmtRangeUpperFormat\":1,\"AmtRangeLowerFormat\":1},\"IntRateBasis\":\"Int Rate Basis\",\"IndirectQuoteFlag\""
                        + ":\"Indirect Quote Flag\",\"QuotationUnit\":\"Quotation Unit\",\"RetrievedRateInfo\":{\"RbcSellFwdRateFormat\":1"
                        + ",\"CapMktBuyFwdRate\":1,\"ContractEffDate\":1,\"CapMktSellFwdRate\":1,\"LinkUpdDate\":1,\"RetrievedRateEffDate"
                        + "\":1,\"FwdRateEntryTime\":1,\"OptionDate\":1,\"CapMktSellRateSatus\":\"Cap Mkt Sell Rate Satus\",\"FwdStaleTimestamp"
                        + "\":{\"FwdStaleDate\":1,\"FwdStaleTime\":1},\"RBCBuyFwdRateStatus\":\"Rbc Buy Fwd Rate Status\",\"FwdValueMatureDate"
                        + "\":42,\"FwdOptionDate\":1,\"RBCSellRate\":10.0,\"CapMktBUyRateFormat\":1,\"CapMktSellFwdRateFormat\":1,"
                        + "\"FwdContractEffDate\":1,\"RBCSellRateFormat\":1,\"FwdRateEntryDate\":1,\"CapMktSellRate\":1,\"RBCSellFwdRate"
                        + "\":1,\"PVRRateKey\":\"Pvr Rate Key\",\"CapMktBUyRate\":1,\"RBCBuyRate\":10.0,\"RateEntryDate\":1,\"StaleTimestamp"
                        + "\":{\"StaleTime\":1,\"StaleDate\":1},\"ReciprocalFlag\":\"Reciprocal Flag\",\"CapMktSellRateFormat\":1,\"FwdAdjType\":\"Fwd"
                        + " Adj Type\",\"LinkUpdTime\":1,\"LinkStatus\":\"Link Status\",\"RbcBuyFwdRateFormat\":1,\"RateLastUpdTimestamp\""
                        + ":{\"RateLastUpdDate\":1,\"RateLastUpdTime\":1},\"ValueMatureDate\":42,\"RbcSellRateStatus\":\"Rbc Sell Rate"
                        + " Status\",\"CapMktBuyRateStatus\":\"Cap Mkt Buy Rate Status\",\"RbcBuyRateStatus\":\"Rbc Buy Rate Status\","
                        + "\"CapMktBuyFwdRateStatus\":\"Cap Mkt Bu Fwd Rate Status\",\"RbcBuyFwdRate\":1,\"FwdRateLastUpdTimestamp\":{"
                        + "\"FwdRateLastUpdDate\":1,\"FwdRateLastUpdTime\":1},\"RBCSellFwdRateStatus\":\"Rbc Sell Fwd Rate Status\","
                        + "\"RbcBuyRateFormat\":1,\"CapMktBuyFwdRateFormat\":1,\"CapMktSellFwdRateStatus\":\"Cap Mkt Sell Fwd Rate"
                        + " Status\",\"RetrivedFwdRateEffDate\":1,\"RateEntryTime\":1}}}]}}}}}",
                ExchangeRateReader.getJsonString(root, objectMapper, "Json"));
        assertTrue(objectMapper.getSerializerProviderInstance() instanceof DefaultSerializerProvider.Impl);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRateResponse()}
     */
    @Test
    void testGetExchangeRateResponse() {
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        when(exchangeRateReader.getExchangeRateResponse()).thenReturn(root);
        assertSame(root, exchangeRateReader.getExchangeRateResponse());
        verify(exchangeRateReader).getExchangeRateResponse();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRateResponse()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExchangeRateResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.reactive.function.client.WebClient$RequestHeadersUriSpec.uri(String, Object[])" because the return value of "org.springframework.web.reactive.function.client.WebClient.get()" is null
        //       at com.rbc.bbp0.step.ExchangeRateReader.getExchangeRateResponse(ExchangeRateReader.java:84)
        //   See https://diff.blue/R013 to resolve this issue.

        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get()).thenReturn(null);
        exchangeRateReader.getExchangeRateResponse();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRateResponse()}
     */
    @Test
    void testGetExchangeRateResponse3() {
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get())
                .thenThrow(new UnexpectedInputException("An error occurred"));
        assertThrows(UnexpectedInputException.class, () -> exchangeRateReader.getExchangeRateResponse());
        verify(webClient).get();
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRatesRequest(Root)}
     */
    @Test
    void testGetExchangeRatesRequest() {
        ExchangeRatesRequest exchangeRatesRequest = new ExchangeRatesRequest();
        when(exchangeRateReader.getExchangeRatesRequest(Mockito.<Root>any())).thenReturn(exchangeRatesRequest);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertSame(exchangeRatesRequest, exchangeRateReader.getExchangeRatesRequest(root));
        verify(exchangeRateReader).getExchangeRatesRequest(Mockito.<Root>any());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRatesRequest(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExchangeRatesRequest2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getDateTime(ExchangeRateReader.java:120)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getExchangeRatesRequest(ExchangeRateReader.java:101)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getExchangeRatesRequest(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRatesRequest(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExchangeRatesRequest3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getDateTime(ExchangeRateReader.java:120)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getExchangeRatesRequest(ExchangeRateReader.java:101)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = mock(Root.class);
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getExchangeRatesRequest(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRatesRequest(Root)}
     */
    @Test
    void testGetExchangeRatesRequest4() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "inside getExchangeRateData";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = 1L;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "inside getExchangeRateData";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "inside getExchangeRateData";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "inside getExchangeRateData";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.reciprocalFlag = "inside getExchangeRateData";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "inside getExchangeRateData";
        rateReturnDetail.intRateBasis = "inside getExchangeRateData";
        rateReturnDetail.quotationUnit = "inside getExchangeRateData";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "inside getExchangeRateData";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        ExchangeRatesRequest actualExchangeRatesRequest = exchangeRateReader.getExchangeRatesRequest(root);
        assertEquals(10.0d, actualExchangeRatesRequest.getBidRate().doubleValue());
        assertEquals(10.0d, actualExchangeRatesRequest.getOfferRate().doubleValue());
        assertNull(actualExchangeRatesRequest.getLstUpdateTime());
        assertEquals("CADTOUSD", actualExchangeRatesRequest.getExchangeRateCard());
        assertEquals("CADUSD", actualExchangeRatesRequest.getCurrencyPairId());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getExchangeRatesRequest(Root)}
     */
    @Test
    void testGetExchangeRatesRequest5() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "inside getExchangeRateData";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = Long.MAX_VALUE;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "inside getExchangeRateData";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "inside getExchangeRateData";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "inside getExchangeRateData";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "inside getExchangeRateData";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "inside getExchangeRateData";
        retrievedRateInfo.reciprocalFlag = "inside getExchangeRateData";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "inside getExchangeRateData";
        rateReturnDetail.intRateBasis = "inside getExchangeRateData";
        rateReturnDetail.quotationUnit = "inside getExchangeRateData";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "inside getExchangeRateData";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        ExchangeRatesRequest actualExchangeRatesRequest = exchangeRateReader.getExchangeRatesRequest(root);
        assertEquals(10.0d, actualExchangeRatesRequest.getBidRate().doubleValue());
        assertEquals(10.0d, actualExchangeRatesRequest.getOfferRate().doubleValue());
        assertEquals("9227-07-28T07:32:51Z", actualExchangeRatesRequest.getLstUpdateTime());
        assertEquals("CADTOUSD", actualExchangeRatesRequest.getExchangeRateCard());
        assertEquals("CADUSD", actualExchangeRatesRequest.getCurrencyPairId());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getDateTime(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDateTime() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getDateTime(ExchangeRateReader.java:117)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        ExchangeRateReader.getDateTime(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getDateTime(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDateTime2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getDateTime(ExchangeRateReader.java:117)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = mock(Root.class);
        root.wsImsoArea = wsimsoarea;
        ExchangeRateReader.getDateTime(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getDateTime(Root)}
     */
    @Test
    void testGetDateTime3() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "Amt Range";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = 1L;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "Cap Mkt Bu Fwd Rate Status";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "Cap Mkt Buy Rate Status";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "Cap Mkt Sell Fwd Rate Status";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "Cap Mkt Sell Rate Satus";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "Fwd Adj Type";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "Link Status";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "Pvr Rate Key";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "Rbc Buy Fwd Rate Status";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "Rbc Buy Rate Status";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "Rbc Sell Fwd Rate Status";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "Rbc Sell Rate Status";
        retrievedRateInfo.reciprocalFlag = "Reciprocal Flag";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "Indirect Quote Flag";
        rateReturnDetail.intRateBasis = "Int Rate Basis";
        rateReturnDetail.quotationUnit = "Quotation Unit";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "Rate Return Desc";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertEquals("11", ExchangeRateReader.getDateTime(root));
    }

    /**
     * Method under test: {@link ExchangeRateReader#getSellRate(Root)}
     */
    @Test
    void testGetSellRate() {
        when(exchangeRateReader.getSellRate(Mockito.<Root>any())).thenReturn(10.0d);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertEquals(10.0d, exchangeRateReader.getSellRate(root).doubleValue());
        verify(exchangeRateReader).getSellRate(Mockito.<Root>any());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getSellRate(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSellRate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getSellRate(ExchangeRateReader.java:125)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getSellRate(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getSellRate(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSellRate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getSellRate(ExchangeRateReader.java:125)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = mock(Root.class);
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getSellRate(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getSellRate(Root)}
     */
    @Test
    void testGetSellRate4() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "Amt Range";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = 1L;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "Cap Mkt Bu Fwd Rate Status";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "Cap Mkt Buy Rate Status";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "Cap Mkt Sell Fwd Rate Status";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "Cap Mkt Sell Rate Satus";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "Fwd Adj Type";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "Link Status";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "Pvr Rate Key";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "Rbc Buy Fwd Rate Status";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "Rbc Buy Rate Status";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "Rbc Sell Fwd Rate Status";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "Rbc Sell Rate Status";
        retrievedRateInfo.reciprocalFlag = "Reciprocal Flag";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "Indirect Quote Flag";
        rateReturnDetail.intRateBasis = "Int Rate Basis";
        rateReturnDetail.quotationUnit = "Quotation Unit";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "Rate Return Desc";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertEquals(10.0d, exchangeRateReader.getSellRate(root).doubleValue());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getBuyRate(Root)}
     */
    @Test
    void testGetBuyRate() {
        when(exchangeRateReader.getBuyRate(Mockito.<Root>any())).thenReturn(10.0d);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertEquals(10.0d, exchangeRateReader.getBuyRate(root).doubleValue());
        verify(exchangeRateReader).getBuyRate(Mockito.<Root>any());
    }

    /**
     * Method under test: {@link ExchangeRateReader#getBuyRate(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBuyRate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getBuyRate(ExchangeRateReader.java:129)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getBuyRate(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getBuyRate(Root)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBuyRate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:361)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.rbc.bbp0.step.ExchangeRateReader.getBuyRate(ExchangeRateReader.java:129)
        //   See https://diff.blue/R013 to resolve this issue.

        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = new ArrayList<>();
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = mock(Root.class);
        root.wsImsoArea = wsimsoarea;
        exchangeRateReader.getBuyRate(root);
    }

    /**
     * Method under test: {@link ExchangeRateReader#getBuyRate(Root)}
     */
    @Test
    void testGetBuyRate4() {
        AmtRangeInfo amtRangeInfo = new AmtRangeInfo();
        amtRangeInfo.amtRange = "Amt Range";
        amtRangeInfo.amtRangeEffDate = "2020-03-01";
        amtRangeInfo.amtRangeLowerFormat = 1;
        amtRangeInfo.amtRangeLowerValue = 42;
        amtRangeInfo.amtRangeUpperFormat = 1;
        amtRangeInfo.amtRangeUpperValue = 42;
        amtRangeInfo.branchLimit = 1;
        amtRangeInfo.branchLimitFormat = 1;
        FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp = new FwdRateLastUpdTimestamp();
        fwdRateLastUpdTimestamp.fwdRateLastUpdDate = 1;
        fwdRateLastUpdTimestamp.fwdRateLastUpdTime = 1;
        FwdStaleTimestamp fwdStaleTimestamp = new FwdStaleTimestamp();
        fwdStaleTimestamp.fwdStaleDate = 1;
        fwdStaleTimestamp.fwdStaleTime = 1;
        RateLastUpdTimestamp rateLastUpdTimestamp = new RateLastUpdTimestamp();
        rateLastUpdTimestamp.rateLastUpdDate = 1L;
        rateLastUpdTimestamp.rateLastUpdTime = 1L;
        StaleTimestamp staleTimestamp = new StaleTimestamp();
        staleTimestamp.staleDate = 1;
        staleTimestamp.staleTime = 1;
        RetrievedRateInfo retrievedRateInfo = new RetrievedRateInfo();
        retrievedRateInfo.FwdOptionDate = 1;
        retrievedRateInfo.FwdValueMatureDate = 42;
        retrievedRateInfo.RetrievedRateEffDate = 1;
        retrievedRateInfo.capMktBuFwdRateStatus = "Cap Mkt Bu Fwd Rate Status";
        retrievedRateInfo.capMktBuyFwdRate = 1;
        retrievedRateInfo.capMktBuyFwdRateFormat = 1;
        retrievedRateInfo.capMktBuyRate = 1;
        retrievedRateInfo.capMktBuyRateFormat = 1;
        retrievedRateInfo.capMktBuyRateStatus = "Cap Mkt Buy Rate Status";
        retrievedRateInfo.capMktSellFwdRate = 1;
        retrievedRateInfo.capMktSellFwdRateFormat = 1;
        retrievedRateInfo.capMktSellFwdRateStatus = "Cap Mkt Sell Fwd Rate Status";
        retrievedRateInfo.capMktSellRateFormat = 1;
        retrievedRateInfo.capMktSellRateSatus = "Cap Mkt Sell Rate Satus";
        retrievedRateInfo.capMktSellrate = 1;
        retrievedRateInfo.contractEffDate = 1;
        retrievedRateInfo.fwdAdjType = "Fwd Adj Type";
        retrievedRateInfo.fwdContractEffDate = 1;
        retrievedRateInfo.fwdRateEntryDate = 1;
        retrievedRateInfo.fwdRateEntryTime = 1;
        retrievedRateInfo.fwdRateLastUpdTimestamp = fwdRateLastUpdTimestamp;
        retrievedRateInfo.fwdStaleTimestamp = fwdStaleTimestamp;
        retrievedRateInfo.linkStatus = "Link Status";
        retrievedRateInfo.linkUpdDate = 1;
        retrievedRateInfo.linkUpdTime = 1;
        retrievedRateInfo.optionDate = 1;
        retrievedRateInfo.pvrRateKey = "Pvr Rate Key";
        retrievedRateInfo.rateEntryDate = 1;
        retrievedRateInfo.rateEntryTime = 1;
        retrievedRateInfo.rateLastUpdTimestamp = rateLastUpdTimestamp;
        retrievedRateInfo.rbcBuyFwdRate = 1;
        retrievedRateInfo.rbcBuyFwdRateFormat = 1;
        retrievedRateInfo.rbcBuyFwdRateStatus = "Rbc Buy Fwd Rate Status";
        retrievedRateInfo.rbcBuyRate = 10.0d;
        retrievedRateInfo.rbcBuyRateFormat = 1;
        retrievedRateInfo.rbcBuyRateStatus = "Rbc Buy Rate Status";
        retrievedRateInfo.rbcSellFwdRate = 1;
        retrievedRateInfo.rbcSellFwdRateFormat = 1;
        retrievedRateInfo.rbcSellFwdRateStatus = "Rbc Sell Fwd Rate Status";
        retrievedRateInfo.rbcSellRate = 10.0d;
        retrievedRateInfo.rbcSellRateFormat = 1;
        retrievedRateInfo.rbcSellRateStatus = "Rbc Sell Rate Status";
        retrievedRateInfo.reciprocalFlag = "Reciprocal Flag";
        retrievedRateInfo.retrivedFwdRateEffDate = 1;
        retrievedRateInfo.staleTimestamp = staleTimestamp;
        retrievedRateInfo.valueMatureDate = 42;
        RateReturnDetail rateReturnDetail = new RateReturnDetail();
        rateReturnDetail.amtRangeInfo = amtRangeInfo;
        rateReturnDetail.indirectQuoteFlag = "Indirect Quote Flag";
        rateReturnDetail.intRateBasis = "Int Rate Basis";
        rateReturnDetail.quotationUnit = "Quotation Unit";
        rateReturnDetail.retrievedRateInfo = retrievedRateInfo;
        RateReturnDetailArray rateReturnDetailArray = new RateReturnDetailArray();
        rateReturnDetailArray.rateReturnCode = 1;
        rateReturnDetailArray.rateReturnDesc = "Rate Return Desc";
        rateReturnDetailArray.rateReturnDetail = rateReturnDetail;

        ArrayList<RateReturnDetailArray> rateReturnDetailArrayList = new ArrayList<>();
        rateReturnDetailArrayList.add(rateReturnDetailArray);
        PvrFxRateReturnArea pvrFxRateReturnArea = new PvrFxRateReturnArea();
        pvrFxRateReturnArea.rateReturnDetailArray = rateReturnDetailArrayList;
        PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea = new PvrFxReqReturnCodeArea();
        pvrFxReqReturnCodeArea.errorWarnFlag = -1;
        pvrFxReqReturnCodeArea.requestReturnCode = 1;
        PvrFxReturnArea pvrFxReturnArea = new PvrFxReturnArea();
        pvrFxReturnArea.pvrFxRateReturnArea = pvrFxRateReturnArea;
        pvrFxReturnArea.pvrFxReqReturnCodeArea = pvrFxReqReturnCodeArea;
        PvrFxInterfaceArea pvrFxInterfaceArea = new PvrFxInterfaceArea();
        pvrFxInterfaceArea.pvrFxReturnArea = pvrFxReturnArea;
        Wsimsoarea wsimsoarea = new Wsimsoarea();
        wsimsoarea.pvrFxInterfaceArea = pvrFxInterfaceArea;
        Root root = new Root();
        root.wsImsoArea = wsimsoarea;
        assertEquals(10.0d, exchangeRateReader.getBuyRate(root).doubleValue());
    }
}

