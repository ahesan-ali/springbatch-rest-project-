package com.rbc.bbp0.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExchangeRatesRequest {
    @NotBlank
    private String exchangeRateCard;
    @NotBlank
    private String currencyPairId;
    @NotNull
    private LocalDate effectiveDate;
    @NotNull
    private Double bidRate;
    @NotNull
    private Double offerRate;
    private Double midRate;
    private String lstUpdateTime;
}
