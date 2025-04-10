package com.example.demo.service;

import com.example.demo.dto.StockQueryParams;
import com.example.demo.entity.Stock;
import org.springframework.data.domain.Page;


public interface StockService  {
        Page<Stock> getStocks(StockQueryParams stockQueryParams);

}
