package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "news_sentiments")
public class NewsSentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsSentimentsId;

    @OneToOne
    @JoinColumn(name = "news_article_id")
    private NewsArticle newsArticle;

    @Column(name = "sentiment_score")
    private BigDecimal sentimentScore;

    @Lob
    private String summary;

    @Lob
    private String keywords;

    @Column(name = "created_date")
    private Date createdDate;
}
