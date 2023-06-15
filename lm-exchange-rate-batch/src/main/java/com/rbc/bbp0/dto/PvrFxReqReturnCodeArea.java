package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class PvrFxReqReturnCodeArea {
    @JsonProperty("RequestReturnCode")
    public int requestReturnCode;
    @JsonProperty("ErrorWarnFlag")
    public int errorWarnFlag;

}
