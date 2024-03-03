package com.patinaud.myconverterapi.controller;


import com.patinaud.myconverterapi.mapper.CurrencyMapper;
import com.patinaud.myconverterapi.model.CurrencyResponse;
import com.patinaud.myconverterdto.dto.currency.CurrencyDto;
import com.patinaud.myconverterservice.service.currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/currency/")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/rates")
    public List<CurrencyResponse> getRates() {

        return CurrencyMapper.mapCurrenciesDtoToResponses(currencyService.getRates());

    }
}
