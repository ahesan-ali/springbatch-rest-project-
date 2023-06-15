package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class PvrFxReturnArea {
    @JsonProperty("PVRFxReqReturnCodeArea")
    public PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea;
    @JsonProperty("PVRFxRateReturnArea")
    public PvrFxRateReturnArea pvrFxRateReturnArea;
}

