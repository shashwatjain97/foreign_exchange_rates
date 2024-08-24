// src/main/java/com/example/forex/controller/ExchangeRateController.java
package com.example.forex.controller;

import com.example.forex.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService service;

    @GetMapping("/fx")
    public Map<String, Object> getRates(@RequestParam(name = "target", defaultValue = "EUR") String targetCurrency) {
        return service.getRates(targetCurrency);
    }

    @GetMapping("/fx/{targetCurrency}")
    public Map<String, Object> getHistoricalRates(@PathVariable String targetCurrency) {
        return service.getHistoricalRates(targetCurrency);
    }
}
