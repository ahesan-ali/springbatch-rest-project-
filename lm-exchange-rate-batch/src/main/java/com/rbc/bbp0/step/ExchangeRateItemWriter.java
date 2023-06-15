package com.rbc.bbp0.step;


import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.request.Root;
import com.rbc.bbp0.dto.response.ExchangeRateResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class ExchangeRateItemWriter implements ItemWriter<ExchangeRatesRequest> {

    private String fxRateApiUrl;
    private final WebClient webClient;

    @Override
    public void write(List<? extends ExchangeRatesRequest> list) throws Exception {

        log.info(">>>> Writing exchange rate data: ");
        if (list != null && !list.isEmpty()) {
            ExchangeRatesRequest exchangeRate = list.get(0);
            getExchangeRateStatus(exchangeRate);
        }
    }
    public void getExchangeRateStatus(ExchangeRatesRequest exchangeRate) {
        if (exchangeRate != null) {
            var root = getRequestObject(exchangeRate);
            try {
                webClient.post().uri(fxRateApiUrl).body(Mono.just(root), Root.class).retrieve().bodyToMono(ExchangeRateResponse.class).block();
            } catch (Exception exception) {
                log.error("Exception while calling the post API: {}", exception.getMessage());
            }
        }
    }

    public Root getRequestObject(ExchangeRatesRequest exchangeRate){

        var root = new Root();
        List<ExchangeRatesRequest> exchangeRatesList = new ArrayList<>();
        exchangeRatesList.add(exchangeRate);
        root.setExchangeRatesRequest(exchangeRatesList);
        log.info("Inside Exchange rate writer, request object for post API: {}", root.toString());
        return root;

    }
}



