package com.example.demo.dto.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class StockPriceDto {
    private Integer stockPriceId;

    private Date tradeDate;

    private BigDecimal openPrice;

    private BigDecimal closePrice;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private Long volume;
}
