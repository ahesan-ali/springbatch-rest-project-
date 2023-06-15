package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
public class PvrFxRateReturnArea {
    @JsonProperty("RateReturnDetailArray")
    public ArrayList<RateReturnDetailArray> rateReturnDetailArray;

}
