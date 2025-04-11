package com.example.demo.repository;

import com.example.demo.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

    // 查詢指定 stockId 且在指定日期範圍內的 StockPrice
    List<StockPrice> findByStock_StockIdAndTradeDateBetween(Integer stockId, Date startDate, Date endDate);

    List<StockPrice> findByStock_StockIdOrderByTradeDateDesc(Long stockId);

    List<StockPrice> findAllByStock_StockId(Integer stockId);

}