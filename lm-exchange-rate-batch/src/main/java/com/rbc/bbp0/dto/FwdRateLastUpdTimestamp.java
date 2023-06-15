package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class FwdRateLastUpdTimestamp{
        @JsonProperty("FwdRateLastUpdDate")
        public int fwdRateLastUpdDate;
        @JsonProperty("FwdRateLastUpdTime")
        public int fwdRateLastUpdTime;
}
