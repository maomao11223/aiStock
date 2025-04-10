package com.example.demo.repository;

import com.example.demo.entity.PricePrediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricePredictionRepository extends JpaRepository<PricePrediction, Long> {
    List<PricePrediction> findByStock_StockIdOrderByPredictionDateDesc(Long stockId);
}