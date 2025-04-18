package com.example.demo.controller;

import com.example.demo.dto.StockPrice.GetStocksPriceRequest;
import com.example.demo.dto.StockPrice.StockPriceDto;
import com.example.demo.entity.StockPrice;
import com.example.demo.model.common.ApiRestResponse;
import com.example.demo.service.StockPriceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/stockPrices")
@RequiredArgsConstructor
public class StockPriceController {


    @Autowired
    private StockPriceService stockPriceService;


    @GetMapping("/{stockId}")
    @Operation(summary = "根據股票 symbol 查詢歷史價格（由資料庫 inner join 查詢）")
    public ApiRestResponse<List<StockPriceDto>> getStockPrices(@ModelAttribute GetStocksPriceRequest getStocksPriceRequest) {

        List<StockPriceDto> stockPriceList = stockPriceService.getStockPricesByStockIdAndDateRange(getStocksPriceRequest);

        System.out.println(stockPriceList);
        return ApiRestResponse.success(stockPriceList);
    }

    @PostMapping
    @Operation(summary = "新增每日價格資料")
    public StockPrice addStockPrice(@RequestBody StockPrice stockPrice) { return null; }

}
