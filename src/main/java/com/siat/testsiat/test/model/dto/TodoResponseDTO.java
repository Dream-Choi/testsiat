package com.siat.testsiat.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TodoResponseDTO {
    private int seq;
    private String title;
    private String content;
    private String startDate;
    private String status;
    private String endDate;
    private int priority;
}
