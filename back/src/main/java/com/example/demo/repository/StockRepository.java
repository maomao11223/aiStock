package com.example.demo.repository;

import com.example.demo.entity.Stock;
import com.example.demo.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> , JpaSpecificationExecutor<Stock> {


    Stock findByStockId(Integer stockId);
}