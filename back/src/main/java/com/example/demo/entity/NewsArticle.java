package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "news_articles")
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsArticleId;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private String title;

    @Lob
    private String content;

    private String source;

    private String url;

    @Column(name = "published_at")
    private Date publishedAt;

    @Column(name = "created_date")
    private Date createdDate;
}
