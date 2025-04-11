package com.example.demo.specification;

import com.example.demo.dto.Stock.StockQueryParams;
import com.example.demo.entity.Stock;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class StockSpecification {
    public static Specification<Stock> buildSpecification(StockQueryParams params) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            /**
             * filtering 增加查詢條件
             * StockQueryParams可以擴充查詢條件
             */
            if (StringUtils.isNotBlank(params.getStockName())) {
                predicates.add(cb.like(root.get("stockName"), "%" + params.getStockName().trim() + "%"));
            }

            return predicates.isEmpty() ? cb.conjunction() : cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

