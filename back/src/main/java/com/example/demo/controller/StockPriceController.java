package com.example.demo.controller;

import com.example.demo.entity.StockPrice;
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
@RequestMapping("/api/stockPrices")
@RequiredArgsConstructor
public class StockPriceController {
    @GetMapping("/{stockId}")
    @Operation(summary = "根據股票 symbol 查詢歷史價格（由資料庫 inner join 查詢）")
    public List<StockPrice> getStockPrices(@PathVariable Long stockId) { return null; }

    @PostMapping
    @Operation(summary = "新增每日價格資料")
    public StockPrice addStockPrice(@RequestBody StockPrice stockPrice) { return null; }

}
