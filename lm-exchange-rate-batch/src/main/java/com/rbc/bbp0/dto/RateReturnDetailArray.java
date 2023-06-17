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
public class RateReturnDetailArray {
    @JsonProperty("RateReturnDesc")
    public String rateReturnDesc;
    @JsonProperty("RateReturnCode")
    public int rateReturnCode;
    @JsonProperty("RateReturnDetail")
    public RateReturnDetail rateReturnDetail;
}
