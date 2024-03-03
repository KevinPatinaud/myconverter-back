package com.patinaud.myconverterdto.dto.currency;


public class CurrencyDto {

    private String symbol;

    private double usdRate;

    public CurrencyDto(String symbol, double usdRate) {
        this.symbol = symbol;
        this.usdRate = usdRate;
    }


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
