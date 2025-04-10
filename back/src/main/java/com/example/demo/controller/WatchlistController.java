package com.example.demo.controller;

import com.example.demo.entity.Stock;
import com.example.demo.entity.Watchlist;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/watchLists")
@RequiredArgsConstructor
public class WatchlistController {

    @PostMapping
    @Operation(summary = "新增一筆追蹤紀錄（user_id + stock_id）")
    public Watchlist addWatch(@RequestBody Watchlist watchlist) { return null; }

    @DeleteMapping("/{watchlistId}")
    @Operation(summary = "移除一筆追蹤紀錄")
    public void deleteWatch(@PathVariable Long watchlistId) { return ; }

    @GetMapping("/{userId}")
    @Operation(summary = "查詢使用者的追蹤股票清單")
    public List<Stock> getUserWatchlist(@PathVariable Long userId) { return null; }

}
