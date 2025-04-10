package com.example.demo.controller;

import com.example.demo.entity.PricePrediction;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pricePredictions")
@RequiredArgsConstructor
public class PricePredictionController {
    @PostMapping
    @Operation(summary = "新增預測資料（通常由 AI 模型產出）")
    public PricePrediction addPricePredictions(@RequestBody PricePrediction prediction) { return null; }

    @GetMapping("/{stockId}")
    public List<PricePrediction> getPredictionsByStockId(@PathVariable Integer stockId) { return null; }


}
