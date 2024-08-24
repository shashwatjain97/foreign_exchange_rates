// src/main/java/com/example/forex/model/ExchangeRate.java
package com.example.forex.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {
    @Id
    private LocalDate date;
    private String source;
    private String target;
    private double rate;

    // Getters and Setters
}
