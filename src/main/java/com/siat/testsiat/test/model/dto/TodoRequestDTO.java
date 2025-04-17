package com.siat.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Schema(description = "Todo 요청 DTO")
public class TodoRequestDTO {
    @Schema(description = "오라클 시퀀스 번호", example = "1")
    private int seq;
    
    private String title;
    private String content;
    private String startDate;
    private String status;
    private String endDate;
    private int priority;
}
