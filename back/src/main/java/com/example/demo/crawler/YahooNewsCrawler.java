package com.example.demo.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class YahooNewsCrawler {
    private static final String NEWS_URL = "https://tw.stock.yahoo.com/quote/2330/news";

    public List<NewsDto> fetchTodayNews() throws IOException {
        List<NewsDto> results = new ArrayList<>();
        Document doc = Jsoup.connect(NEWS_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                .timeout(10000)
                .get();

//        System.out.println("頁面結構： "+doc.html());

        Elements items = doc.select("li.js-stream-content");
        String today = LocalDate.now().toString(); // yyyy-MM-dd

        for (Element item : items) {
            String title = item.select("h3 a").text();
            String link = "https://tw.stock.yahoo.com" + item.select("a").attr("href");


            System.out.println("=====新聞項目=====");
            System.out.println(item.html());

//            String date = item.select("time").text();

//            if (date.contains("小時前") || date.contains("分鐘前") || date.contains(today)) {
//                results.add(new NewsDto(title, link, date));
//            }

            results.add(new NewsDto(title,link));
        }

        return results;
    }

}
