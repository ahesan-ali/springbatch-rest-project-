package com.rbc.bbp0.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RateReturnDetail {
    @JsonProperty("AmtRangeInfo")
    public AmtRangeInfo amtRangeInfo;
    @JsonProperty("IntRateBasis")
    public String intRateBasis;
    @JsonProperty("IndirectQuoteFlag")
    public String indirectQuoteFlag;
    @JsonProperty("QuotationUnit")
    public String quotationUnit;
    @JsonProperty("RetrievedRateInfo")
    public RetrievedRateInfo retrievedRateInfo;
}
