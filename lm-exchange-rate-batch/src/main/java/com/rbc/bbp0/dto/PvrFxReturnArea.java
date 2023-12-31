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
public class PvrFxReturnArea {
    @JsonProperty("PVRFxReqReturnCodeArea")
    public PvrFxReqReturnCodeArea pvrFxReqReturnCodeArea;
    @JsonProperty("PVRFxRateReturnArea")
    public PvrFxRateReturnArea pvrFxRateReturnArea;
}

