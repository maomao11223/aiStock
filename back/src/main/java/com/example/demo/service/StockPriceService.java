package com.example.demo.service;

import com.example.demo.dto.StockPrice.GetStocksPriceRequest;
import com.example.demo.dto.StockPrice.StockPriceDto;
import com.example.demo.entity.StockPrice;

import java.util.List;

public interface StockPriceService {


    List<StockPriceDto> getStockPricesByStockIdAndDateRange(GetStocksPriceRequest getStocksPriceRequest);
}
