// src/main/java/com/example/forex/service/ExchangeRateService.java
package com.example.forex.service;

import com.example.forex.model.ExchangeRate;
import com.example.forex.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository repository;

    private final String BASE_URL = "https://api.frankfurter.app";
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getRates(String targetCurrency) {
        LocalDate today = LocalDate.now();
        Map<String, Object> response = new HashMap<>();
        response.put("date", today.toString());
        response.put("source", "USD");

        List<ExchangeRate> rates = repository.findAll();
        if (rates.isEmpty()) {
            // Fetch data from external API
            String url = BASE_URL + "/latest?to=" + targetCurrency;
            Map<String, Object> apiResponse = restTemplate.getForObject(url, Map.class);
            // Process and save data to the repository
            // Assume API response contains rates
            // TODO: Save fetched data
        }

        // Add rates to response
        response.put("rates", rates);

        return response;
    }

    public Map<String, Object> getHistoricalRates(String targetCurrency) {
        LocalDate today = LocalDate.now();
        List<ExchangeRate> rates = repository.findTop3ByTargetAndDateLessThanOrderByDateDesc(targetCurrency, today);

        Map<String, Object> response = new HashMap<>();
        response.put("source", "USD");
        Map<String, Map<String, Object>> rateMap = new HashMap<>();
        for (ExchangeRate rate : rates) {
            Map<String, Object> rateDetails = new HashMap<>();
            rateDetails.put("target", rate.getTarget());
            rateDetails.put("value", rate.getRate());
            rateMap.put(rate.getDate().toString(), rateDetails);
        }
        response.put("rates", rateMap);

        return response;
    }
}
