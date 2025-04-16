package com.siat.testsiat.test.model.dto;

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
public class TodoRequestDTO {
    private int seq;
    private String title;
    private String content;
    private String startDate;
    private String status;
    private String endDate;
    private int priority;
}
