package com.example.demo.controller;

import com.example.demo.dto.StockQueryParams;
import com.example.demo.entity.Stock;
import com.example.demo.model.common.ApiRestResponse;
import com.example.demo.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    @Operation(summary = "取得所有Stock")
    public ApiRestResponse<Page<Stock>> getAllStocks(
            @ModelAttribute StockQueryParams stockQueryParams
    ) {
        Page<Stock> result = stockService.getStocks(stockQueryParams);

        return ApiRestResponse.success(result);
    }

//    @GetMapping("/{stockId}")
//    @Operation(summary = "根據stockId查詢特定股票的詳細資料")
//    public ApiRestResponse<List<StockPrice>> getStockByStockId(@PathVariable Integer stockId) {
//        List<StockPrice> stockPrices = stockService.getStockPricesByStockId(stockId);
//        return ApiRestResponse.success(stockPrices);
//    }

    @PostMapping
    @Operation(summary = "新增股票資料")
    public void addStock() {
    }

    @DeleteMapping("/{symbol}")
    @Operation(summary = "刪除特定股票")
    public String deleteStock(@PathVariable String symbol) {
        return symbol;
    }


}
