package com.example.demo.dto.StockPrice;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class GetStocksPriceRequest {
    @NotBlank
    private Integer stockId;

    private Date startDate;

    private Date endDate;
}
