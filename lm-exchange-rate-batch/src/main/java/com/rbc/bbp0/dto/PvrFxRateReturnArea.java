package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PvrFxRateReturnArea {
    @JsonProperty("RateReturnDetailArray")
    public ArrayList<RateReturnDetailArray> rateReturnDetailArray;

}
