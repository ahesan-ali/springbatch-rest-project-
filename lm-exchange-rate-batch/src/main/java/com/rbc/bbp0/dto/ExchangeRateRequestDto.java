package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ExchangeRateRequestDto {
    @JsonProperty("ApplCode")
    private String applCode;
    @JsonProperty("ApplDesc")
    private String applDesc;
    @JsonProperty("InqUsage")
    private String inqUsage;
    @JsonProperty("ProdGrp01")
    private String prodGrp01;
    @JsonProperty("ProdId01")
    private String prodId01;
    @JsonProperty("PrimCurr01")
    private String primCurr01;
    @JsonProperty("SecCurr01")
    private String secCurr01;
    @JsonProperty("RateClass01")
    private String rateClass01;
    @JsonProperty("Type01")
    private String type01;
    @JsonProperty("Term01")
    private String term01;
    @JsonProperty("AmtRange01")
    private String amtRange01;
}
