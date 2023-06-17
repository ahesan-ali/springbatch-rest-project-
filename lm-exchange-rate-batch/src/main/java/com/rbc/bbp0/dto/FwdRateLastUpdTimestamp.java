package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FwdRateLastUpdTimestamp{
        @JsonProperty("FwdRateLastUpdDate")
        public int fwdRateLastUpdDate;
        @JsonProperty("FwdRateLastUpdTime")
        public int fwdRateLastUpdTime;
}
