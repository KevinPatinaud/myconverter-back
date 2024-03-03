package com.patinaud.myconverterapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyResponse {

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("usdRate")
    private double usdRate;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }
}
