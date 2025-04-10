package com.example.demo.crawler;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class YahooNewsCrawlerTest {

    @Test
    void fetchTodayNews() throws IOException {
        YahooNewsCrawler crawler = new YahooNewsCrawler();

        // 假設你要測試的股票代號是 "2330.TW"
        List<NewsDto> newsList = crawler.fetchTodayNews();

        // 檢查抓取到的新聞數量
        assertTrue(newsList.size() > 0, "新聞列表應該至少有一條新聞");

        // 檢查每條新聞是否包含標題和 URL
        for (NewsDto news : newsList) {
            assertNotNull(news.getTitle(), "新聞標題不應該為空");
            assertNotNull(news.getUrl(), "新聞連結不應該為空");
        }
    }
}