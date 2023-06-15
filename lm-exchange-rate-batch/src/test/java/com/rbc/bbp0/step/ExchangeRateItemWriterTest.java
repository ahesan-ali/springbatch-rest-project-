package com.rbc.bbp0.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.request.Root;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ContextConfiguration(classes = {ExchangeRateItemWriter.class, String.class})
@ExtendWith(SpringExtension.class)
class ExchangeRateItemWriterTest {
    @MockBean
    private WebClient webClient;

    @MockBean
    private ExchangeRateItemWriter exchangeRateItemWriter;

    /**
     * Method under test: {@link ExchangeRateItemWriter#ExchangeRateItemWriter(String, WebClient)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ExchangeRateItemWriter.fxRateApiUrl
        //     ExchangeRateItemWriter.webClient

        new ExchangeRateItemWriter("https://example.org/example", null);

    }

    @Test
    void testWrite() throws Exception {
        doNothing().when(exchangeRateItemWriter).write(Mockito.<List<ExchangeRatesRequest>>any());
        exchangeRateItemWriter.write(new ArrayList<>());
        verify(exchangeRateItemWriter).write(Mockito.<List<ExchangeRatesRequest>>any());
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#write(List)}
     */
    @Test
    void testWrite2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ExchangeRateItemWriter.fxRateApiUrl
        //     ExchangeRateItemWriter.webClient

        exchangeRateItemWriter.write(new ArrayList<>());
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#write(List)}
     */
    @Test
    void testWrite3() throws Exception {
        when(webClient.post()).thenReturn(null);

        ArrayList<ExchangeRatesRequest> list = new ArrayList<>();
        list.add(new ExchangeRatesRequest());
        exchangeRateItemWriter.write(list);
        verify(webClient).post();
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#write(List)}
     */
    @Test
    void testWrite4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ExchangeRateItemWriter.fxRateApiUrl
        //     ExchangeRateItemWriter.webClient

        when(webClient.post()).thenReturn(null);

        ArrayList<ExchangeRatesRequest> list = new ArrayList<>();
        list.add(null);
        exchangeRateItemWriter.write(list);
    }

    @Test
    void testGetExchangeRateStatus() {
        doNothing().when(exchangeRateItemWriter).getExchangeRateStatus(Mockito.<ExchangeRatesRequest>any());
        exchangeRateItemWriter.getExchangeRateStatus(new ExchangeRatesRequest());
        verify(exchangeRateItemWriter).getExchangeRateStatus(Mockito.<ExchangeRatesRequest>any());
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#getExchangeRateStatus(ExchangeRatesRequest)}
     */
    @Test
    void testGetExchangeRateStatus2() {
        when(webClient.post()).thenReturn(null);
        exchangeRateItemWriter.getExchangeRateStatus(new ExchangeRatesRequest());
        verify(webClient).post();
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#getExchangeRateStatus(ExchangeRatesRequest)}
     */
    @Test
    void testGetExchangeRateStatus3() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ExchangeRateItemWriter.fxRateApiUrl
        //     ExchangeRateItemWriter.webClient

        when(webClient.post()).thenReturn(null);
        exchangeRateItemWriter.getExchangeRateStatus(null);
    }

    @Test
    void testGetRequestObject() {
        Root root = new Root();
        when(exchangeRateItemWriter.getRequestObject(Mockito.<ExchangeRatesRequest>any())).thenReturn(root);
        assertSame(root, exchangeRateItemWriter.getRequestObject(new ExchangeRatesRequest()));
        verify(exchangeRateItemWriter).getRequestObject(Mockito.<ExchangeRatesRequest>any());
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#getRequestObject(ExchangeRatesRequest)}
     */
    @Test
    void testGetRequestObject2() {
        assertEquals(1,
                exchangeRateItemWriter.getRequestObject(new ExchangeRatesRequest()).getExchangeRatesRequest().size());
    }

    /**
     * Method under test: {@link ExchangeRateItemWriter#getRequestObject(ExchangeRatesRequest)}
     */
    @Test
    void testGetRequestObject3() {
        assertEquals(1,
                exchangeRateItemWriter.getRequestObject(mock(ExchangeRatesRequest.class)).getExchangeRatesRequest().size());
    }
}

