package com.patinaud.myconverterservice.service.currency;

import com.patinaud.myconverterdto.dto.currency.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    public List<CurrencyDto> getRates();
}
