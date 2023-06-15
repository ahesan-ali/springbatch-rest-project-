package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaleTimestamp {
    @JsonProperty("StaleTime")
    public int staleTime;
    @JsonProperty("StaleDate")
    public int staleDate;
}
