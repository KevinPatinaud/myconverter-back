package com.patinaud.myconverterapi.mapper;

import com.patinaud.myconverterapi.model.CurrencyResponse;
import com.patinaud.myconverterdto.dto.currency.CurrencyDto;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMapper {

    public static CurrencyResponse mapCurrencyDtoToResponse(CurrencyDto curencyDto) {
        CurrencyResponse resp = new CurrencyResponse();
        resp.setSymbol(curencyDto.getSymbol());
        resp.setUsdRate(curencyDto.getUsdRate());
        return resp;
    }

    public static List<CurrencyResponse> mapCurrenciesDtoToResponses(List<CurrencyDto> currenciesDto) {
        ArrayList<CurrencyResponse> resp = new ArrayList<CurrencyResponse>();
        
        return currenciesDto.parallelStream().map((currencyDto) -> mapCurrencyDtoToResponse(currencyDto)).toList();

    }

}
