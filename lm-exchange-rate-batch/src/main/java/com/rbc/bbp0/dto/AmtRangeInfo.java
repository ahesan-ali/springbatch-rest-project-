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
public class AmtRangeInfo {
    @JsonProperty("AmtRangeLowerValue")
    public int amtRangeLowerValue;
    @JsonProperty("BranchLimitFormat")
    public int branchLimitFormat;
    @JsonProperty("AmtRange")
    public String amtRange;
    @JsonProperty("AmtRangeUpperValue")
    public int amtRangeUpperValue;
    @JsonProperty("BranchLimit")
    public int branchLimit;
    @JsonProperty("AmtRangeEffDate")
    public String amtRangeEffDate;
    @JsonProperty("AmtRangeUpperFormat")
    public int amtRangeUpperFormat;
    @JsonProperty("AmtRangeLowerFormat")
    public int amtRangeLowerFormat;
}
