package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FwdStaleTimestamp {
    @JsonProperty("FwdStaleDate")
    public int fwdStaleDate;
    @JsonProperty("FwdStaleTime")
    public int fwdStaleTime;
}
