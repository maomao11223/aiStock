package com.example.demo.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


// 查詢的分頁基礎設定
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PageDto {

    @Schema(description = "排序條件",example = "createdDate")
    private String orderBy="createdDate";

    @Schema(description = "排序條件",example = "asc")
    private String sortBy="asc";

    @Schema(description = "顯示多少筆數據",example = "10")
    private Integer size=10;

    @Schema(description = "分頁索引",example = "0")
    private Integer page=0;
}
