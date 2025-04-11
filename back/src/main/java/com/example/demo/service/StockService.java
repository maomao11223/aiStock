package com.example.demo.service;

import com.example.demo.dto.Stock.StockQueryParams;
import com.example.demo.entity.Stock;
import com.example.demo.entity.StockPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;


public interface StockService{

        Page<Stock> getStocks(StockQueryParams stockQueryParams);

        Stock getByStockId(Integer stockId);

        }
