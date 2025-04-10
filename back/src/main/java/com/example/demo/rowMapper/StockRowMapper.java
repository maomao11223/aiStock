package com.example.demo.rowMapper;

import com.example.demo.entity.Stock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockRowMapper implements RowMapper<Stock> {

    @Override
    public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stock stock = new Stock();
        stock.setStockId(rs.getInt("stock_id"));
        stock.setStockName(rs.getString("name"));
        stock.setSymbol(rs.getString("symbol"));
        stock.setIndustry(rs.getString("industry"));
        stock.setMarket(rs.getString("market"));
        stock.setCreatedDate(rs.getDate("created_date"));
        return stock;
    }
}
