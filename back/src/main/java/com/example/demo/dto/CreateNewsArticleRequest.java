package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateNewsArticleRequest {
    private Integer stockId;
    private String title;
    private String content;
    private String source;
    private String url;
    private Date publishedAt;

}
