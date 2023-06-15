package com.rbc.bbp0.controller;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.dto.response.ExchangeRateResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchangeRate")
public class ExchangeRateController {

    @RequestMapping(value="/checkRateStatus",method = RequestMethod.POST)
    public ExchangeRateResponse checkExchangeRate(@RequestBody ExchangeRatesRequest exchangeRateRequest){
        System.out.println("post request called from ExchangeRateController");
        System.out.println("exchange Rate Object" + exchangeRateRequest.toString());
        return new ExchangeRateResponse("S","GHOO","Success");
    }
}
