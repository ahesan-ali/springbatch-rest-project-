package com.rbc.bbp0.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RateReturnDetailArray {
    @JsonProperty("RateReturnDesc")
    public String rateReturnDesc;
    @JsonProperty("RateReturnCode")
    public int rateReturnCode;
    @JsonProperty("RateReturnDetail")
    public RateReturnDetail rateReturnDetail;
}
