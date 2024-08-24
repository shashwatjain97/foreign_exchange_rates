// src/test/java/com/example/forex/ExchangeRateControllerTests.java
package com.example.forex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class ExchangeRateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeRateService service;

    @BeforeEach
    void setUp() {
        // Setup initial state if needed
    }

    @Test
    void testGetRates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fx"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.source").value("USD"));
    }

    @Test
    void testGetHistoricalRates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fx/GBP"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.source").value("USD"));
    }
}
