package com.siat.testsiat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@SpringBootTest
public class MybatisApp {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void insertTest(){
        System.out.println("debug : insertTest");
        TodoRequestDTO request = TodoRequestDTO.builder()
                .title("Test Title")
                .content("Test Content")
                .status("Y")
                .priority(1)
                .build();
        int flag = testMapper.insertRow(request);
        System.out.println("flag : " + flag);
        
    }
    @Test
    public void selectListTest(){
        System.out.println("debug : selectListTest");
        List<TodoResponseDTO> list =testMapper.selectListRow();
        for (TodoResponseDTO response : list) {
            System.out.println(response);
        }
    }
    @Test
    public void updateTest(){
        System.out.println("debug : updateTest");
        Map<String, Object> map = new HashMap<>();
        map.put("seq", 45);
        map.put("title", "Updated Title");
        map.put("content", "Updated Content");
        map.put("status", "Y");
        map.put("priority", 2);
        int flag = testMapper.updateRow(map);
        System.out.println("flag : " + flag);
    }
    @Test
    public void selectRowTest(){
        System.out.println("debug : selectRowTest");
        int seq = 45;
        TodoResponseDTO flag = testMapper.selectRow(seq);
        System.out.println("flag : " + flag);
    } 
    @Test
    public void deleteTest(){
        System.out.println("debug : deleteTest");
        int flag = testMapper.deleteRow(46);
        System.out.println("flag : " + flag);
    }
}
