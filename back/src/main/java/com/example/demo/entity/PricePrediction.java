package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name = "price_predictions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"stock_id", "prediction_date"})
})
public class PricePrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "prediction_date")
    private Date predictionDate;

    @Column(name = "predicted_range_low")
    private BigDecimal predictedRangeLow;

    @Column(name = "predicted_range_high")
    private BigDecimal predictedRangeHigh;

    private BigDecimal confidence;

    @Column(name = "source_model")
    private String sourceModel;

    @Column(name = "created_date")
    private Date createdDate;
}
