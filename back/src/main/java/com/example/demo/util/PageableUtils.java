package com.example.demo.util;


import com.example.demo.dto.common.PageDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtils {
    public static Pageable fromParams(PageDto pageDto) {
        String orderBy =  pageDto.getOrderBy()  ;
        String sortBy =  pageDto.getSortBy() ;
        int page =   pageDto.getPage()  ;
        int size =  pageDto.getSize()  ;

        Sort.Direction direction = Sort.Direction.fromString(sortBy);
        Sort.Order order = new Sort.Order(direction, orderBy);

        return PageRequest.of(page, size, Sort.by(order));
    }
}
