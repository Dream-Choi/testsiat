package com.siat.testsiat;


import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class ServiceApp {
    @Autowired
    private TestService testService;
    @Test
    public void read(){
        System.out.println("debug : read");
        int seq =48;
        TodoResponseDTO response = testService.selectService(seq);
        System.out.println("response : " + response);
        Assertions.assertThat(response).withFailMessage("정상적으로 데이터를 조회 못함").isNotNull();
    }
}
