package com.example.demo.controller;

import com.example.demo.entity.NewsSentiment;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newsSentiments")
@RequiredArgsConstructor
public class NewsSentimentController {
    @PostMapping
    @Operation(summary = "新增情緒分析結果（由 DeepSeek 分析後回傳）")
    public NewsSentiment addSentiment(@RequestBody NewsSentiment sentiment) { return null; }

    @GetMapping("/{newsArticleId}")
    @Operation(summary = "查詢特定新聞的情緒分析結果")
    public NewsSentiment getSentimentByNewsArticleId(@PathVariable Integer newsArticleId) { return null; }

}
