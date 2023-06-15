package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class RateLastUpdTimestamp {
    @JsonProperty("RateLastUpdDate")
    public Long rateLastUpdDate;
    @JsonProperty("RateLastUpdTime")
    public Long rateLastUpdTime;
}
