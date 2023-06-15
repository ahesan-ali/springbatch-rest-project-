package com.rbc.bbp0.step;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbc.bbp0.constant.ApplicationConstant;
import com.rbc.bbp0.dto.Root;
import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.util.ExchangeRateUtility;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;


@Slf4j
public class ExchangeRateReader implements ItemReader<ExchangeRatesRequest> {

    private final String fxRateApiUrl;
    private final String apiUsername;
    private final String apiPassword;

    private final WebClient webClient;
    private boolean batchJobState = false;

    public ExchangeRateReader(String fxRateApiUrl, String apiUsername, String apiPassword, WebClient webClient) {
    this.apiPassword=apiPassword;
    this.apiUsername=apiUsername;
    this.fxRateApiUrl=fxRateApiUrl;
    this.webClient=webClient;
    }

    @Override
    public ExchangeRatesRequest read() throws Exception {
        log.info("Reading the information of the next exchange rate");
        if (!batchJobState) {
            batchJobState = true;
            return fetchexchangerateDataFromApi();
        }
        return null;
    }

    public ExchangeRatesRequest fetchexchangerateDataFromApi(){
        log.debug("Fetching exchange rate data from external API using url: {}", fxRateApiUrl);
        var exchangeRate = getExchangeRate();
        log.info("Inside Exchange rate reader: Exchange rate request");
        return exchangeRate;
    }

    public ExchangeRatesRequest getExchangeRate() {
        Root root = null;
        ExchangeRatesRequest exchangeRatesRequest = null;
        var objectMapper = new ObjectMapper();
        try {
            root = getExchangeRateResponse();
            objectMapper.writer().withDefaultPrettyPrinter();
            String json = null;
            json = getJsonString(root, objectMapper, json);
            log.info("Exchange rate api request in json: {}", json);
            if (root != null) {
                exchangeRatesRequest = getExchangeRatesRequest(root);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return exchangeRatesRequest;
    }

    public static String getJsonString(Root root, ObjectMapper objectMapper, String json){
        try{
            json = objectMapper.writeValueAsString(root);
        }catch (JsonProcessingException e){
            log.error("Error while processing json: {}", e.getMessage());
        }
        return json;
    }

    public Root getExchangeRateResponse() {
        Root root;
        root = webClient.get().uri(fxRateApiUrl).headers(httpHeaders -> httpHeaders.setBasicAuth(apiUsername, apiPassword)).retrieve().onStatus(HttpStatus::isError, response -> {
            if (response.statusCode().is4xxClientError()) {
                log.error("Response from service is 4xx");
            } else {
                log.error("Response from service is 5xx");
            }
            return Mono.error(new Exception("Service response status non 2xx"));
        }).bodyToMono(Root.class).onErrorMap(Predicate.not(Exception.class::isInstance), throwable -> {
            log.error("Failed to send request to service", throwable);
            return new Exception("Service request failed");
        }).block();
        return root;
    }
    public ExchangeRatesRequest getExchangeRatesRequest(Root root) {
        log.info("inside getExchangeRateData");
        var exchangeRatesRequest = new ExchangeRatesRequest();
        exchangeRatesRequest.setEffectiveDate(ExchangeRateUtility.getLocalDateTime().toLocalDate());
        String dateTime = getDateTime(root);
        var readingFormat = new SimpleDateFormat(ApplicationConstant.ORIGINAL_STRING_FORMAT);
        var outputFormat = new SimpleDateFormat(ApplicationConstant.DESIRED_STRING_FORMAT);
        String lstUpdateTime = null;
        try {
            var lstdateTime = readingFormat.parse(dateTime);
            lstUpdateTime = outputFormat.format(lstdateTime);
        } catch (ParseException e) {
            log.error("Error while parsing the date time: {}", e.getMessage());
        }
        exchangeRatesRequest.setCurrencyPairId(ApplicationConstant.CURRENCY_PAIR_ID);
        exchangeRatesRequest.setExchangeRateCard(ApplicationConstant.CURRENCY_RATE_CARD);
        exchangeRatesRequest.setBidRate(getBuyRate(root));
        exchangeRatesRequest.setOfferRate(getSellRate(root));
        exchangeRatesRequest.setLstUpdateTime(lstUpdateTime);
        return exchangeRatesRequest;
    }

    public static String getDateTime(Root root){
        var date = String.valueOf(root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rateLastUpdTimestamp.rateLastUpdDate);
        var time = String.valueOf(root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rateLastUpdTimestamp.rateLastUpdTime);
        return date.concat(time);
    }
    public Double getSellRate(Root root) {
        return root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rbcSellRate;
    }

    public Double getBuyRate(Root root) {
        return root.wsImsoArea.pvrFxInterfaceArea.pvrFxReturnArea.pvrFxRateReturnArea.rateReturnDetailArray.get(0).rateReturnDetail.retrievedRateInfo.rbcBuyRate;
    }
}










