package com.patinaud.myconverterservice.service.currency;

import com.patinaud.myconverterdto.dto.currency.CurrencyDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private String apiRatesCached = null;
    private long lastUpdatedCachedRates = 0;

    private final int updateCacheFrequencyInMinutes = 5;

    @Override
    public List<CurrencyDto> getRates() {

        if (apiRatesCached == null || lastUpdatedCachedRates < System.currentTimeMillis() - updateCacheFrequencyInMinutes * 60 * 1000) {
            apiRatesCached = getRatesFromExternalApi();
            lastUpdatedCachedRates = System.currentTimeMillis();
        }
        ArrayList<CurrencyDto> currenciesResult = new ArrayList<CurrencyDto>();

        try {
            final JSONObject obj = new JSONObject(apiRatesCached);
            final JSONObject ratesJson = obj.getJSONObject("rates");

            java.util.Iterator currencyIterator = ratesJson.keys();


            while (currencyIterator.hasNext()) {
                String symbol = currencyIterator.next().toString();
                Double rate = ratesJson.getDouble(symbol);

                currenciesResult.add(new CurrencyDto(symbol, rate));

            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        return currenciesResult;
    }


    private String getRatesFromExternalApi() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openexchangerates.org/api/latest.json?app_id=7dd0e0f0dec74fd6ab589afbbd9a8b2e&prettyprint=true&show_alternative=true"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String apiResponse = response.body();

        return apiResponse;

    }

}
