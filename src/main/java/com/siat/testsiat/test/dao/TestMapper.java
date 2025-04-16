package com.siat.testsiat.test.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@Mapper
public interface TestMapper {    
    public int insertRow(TodoRequestDTO param);
    public List<TodoResponseDTO> selectListRow();
    public int updateRow(Map<String, Object> map);
    public int deleteRow(int seq);
    public TodoResponseDTO selectRow(int seq);
}
