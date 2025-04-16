package com.siat.testsiat.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.dao.TestDao;
import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
      
    public int insertService(TodoRequestDTO param) {
        System.out.println("service insertRow");
        return testMapper.insertRow(param);
    }
    public List<TodoResponseDTO> selectListService() {
        System.out.println("service selectListRow");
        return testMapper.selectListRow();
    }
    public int updateService(Map<String, Object> map) {
        System.out.println("service updateRow");
        return testMapper.updateRow(map);
    }
    public int deleteService(int seq) {
        System.out.println("service deleteRow");
        return testMapper.deleteRow(seq);
    }
    public TodoResponseDTO selectService(int seq) {
        System.out.println("service selectRow");
        return testMapper.selectRow(seq);
    }
    
    
}
