package com.siat.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    /*
     validation 할수있는 Annotation
     @NotNull : null이 아닌지 체크
     @NotEmpty : null이 아니고 빈문자열이 아닌지 체크
     @NotBlank : null이 아니고 빈문자열이 아니고 공백이 아닌지 체크
     @Past : 과거 날짜인지 체크
     @PastOrPresent : 과거 날짜 또는 현재 날짜인지 체크
     @Size(min=1, max=10) : 길이가 1~10인지 체크
     @Min : 최소값 체크
     @Max : 최대값 체크
     @Pattern : 정규표현식 체크
     */
    @Schema(description = "오라클 시퀀스 번호", example = "1")
    private int seq;
    @NotBlank(message = "제목은 필수 입력입니다.")
    private String title;
    @NotBlank(message = "내용은 필수 입력입니다.")
    private String content;
    @Pattern(regexp="^\\d{2,3}-\\d{4}-\\d{4}$", message = "전화번호 형식에 맞게 입력.")
    private String phone;

    private String startDate;
    private String status;
    private String endDate;
    @Min(value = 1, message = "우선순위는 1 이상이어야 합니다.")
    @Max(value = 10, message = "우선순위는 10 이하여야 합니다.")
    private int priority;
}
