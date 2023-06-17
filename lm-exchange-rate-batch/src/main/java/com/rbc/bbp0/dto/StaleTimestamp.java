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
public class StaleTimestamp {
    @JsonProperty("StaleTime")
    public int staleTime;
    @JsonProperty("StaleDate")
    public int staleDate;
}
