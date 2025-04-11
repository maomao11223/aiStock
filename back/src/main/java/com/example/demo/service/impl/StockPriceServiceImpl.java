package com.example.demo.service.impl;

import com.example.demo.dto.StockPrice.GetStocksPriceRequest;
import com.example.demo.dto.StockPrice.StockPriceDto;
import com.example.demo.entity.StockPrice;
import com.example.demo.repository.StockPriceRepository;
import com.example.demo.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockPriceServiceImpl implements StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;


    @Override
    public List<StockPriceDto> getStockPricesByStockIdAndDateRange(GetStocksPriceRequest getStocksPriceRequest) {


        Integer stockId = getStocksPriceRequest.getStockId();
        Date startDate = getStocksPriceRequest.getStartDate();
        Date endDate = getStocksPriceRequest.getEndDate();

        if (endDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            endDate = calendar.getTime();
        }

        if (startDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            calendar.add(Calendar.YEAR, -1);
            startDate = calendar.getTime();
        }

        System.out.println("startDate: " + startDate);
        System.out.println("endDate: " + endDate);


        return stockPriceRepository.findByStock_StockIdAndTradeDateBetween(stockId, startDate, endDate)
                .stream()
                .map(sp -> new StockPriceDto(
                        sp.getStockPriceId(),
                        sp.getTradeDate(),
                        sp.getOpenPrice(),
                        sp.getClosePrice(),
                        sp.getHighPrice(),
                        sp.getLowPrice(),
                        sp.getVolume()
                ))
                .collect(Collectors.toList());



    }
}
