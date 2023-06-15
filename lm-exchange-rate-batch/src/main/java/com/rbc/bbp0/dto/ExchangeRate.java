package com.rbc.bbp0.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExchangeRate{
    private String interfaceName;
    private String exchangeRateCard;
    private String currencyPairId;
    private LocalDate effectiveDate;
    private String bidRate;
    private String offerRate;
    private String midRate;
    private String lstUpdateTime;
    private String status;
    private String errorCode;
    private String errorDescription;
}
