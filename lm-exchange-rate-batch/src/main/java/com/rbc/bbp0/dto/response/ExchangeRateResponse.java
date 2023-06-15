package com.rbc.bbp0.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExchangeRateResponse {

    @NotBlank
    private String status;
    private String errorCode;
    private String errorMessage;
}
