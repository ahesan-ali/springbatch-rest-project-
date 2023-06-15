package com.rbc.bbp0.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Root {
    @JsonProperty("ExchangeRatesRequest")
    public List<ExchangeRatesRequest> exchangeRatesRequest;
}
