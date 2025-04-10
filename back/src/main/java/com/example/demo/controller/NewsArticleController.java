package com.example.demo.controller;

import com.example.demo.dto.CreateNewsArticleRequest;
import com.example.demo.entity.NewsArticle;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/newsArticles")
@RequiredArgsConstructor
public class NewsArticleController {

    @PostMapping("/{newsArticlesId}")
    @Operation(summary = "新增新聞文章")
    public String addNews(
            @PathVariable Integer newsArticlesId,
            @RequestBody CreateNewsArticleRequest createNewsArticleRequest) {
        return "success";
    }


    @GetMapping
    @Operation(summary = "查詢所有新聞（可加上條件如 stockId）")
    public List<NewsArticle> getNewsByStockId(@PathVariable Integer stockId) {
        return null;
    }



}
