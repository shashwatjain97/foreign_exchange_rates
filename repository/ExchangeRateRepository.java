// src/main/java/com/example/forex/repository/ExchangeRateRepository.java
package com.example.forex.repository;

import com.example.forex.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, LocalDate> {
    List<ExchangeRate> findTop3ByTargetAndDateLessThanOrderByDateDesc(String target, LocalDate date);
}
