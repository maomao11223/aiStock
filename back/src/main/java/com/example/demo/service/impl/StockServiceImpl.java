package com.example.demo.service.impl;

import com.example.demo.dto.StockQueryParams;
import com.example.demo.entity.Stock;
import com.example.demo.repository.StockPriceRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import com.example.demo.specification.StockSpecification;
import com.example.demo.util.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockPriceRepository stockPriceRepository;


    @Override
    public Page<Stock> getStocks(StockQueryParams stockQueryParams) {
        // 設定分頁
        Pageable pageable = PageableUtils.fromParams(stockQueryParams);

        // 設定查詢條件
        Specification<Stock> spec = StockSpecification.buildSpecification(stockQueryParams);

        return stockRepository.findAll(spec, pageable);
    }

}
