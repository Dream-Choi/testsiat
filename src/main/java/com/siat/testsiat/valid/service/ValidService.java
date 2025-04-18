package com.siat.testsiat.valid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.valid.dao.ValidDao;
import com.siat.testsiat.valid.domain.entity.TodoEntity;

@Service
public class ValidService {
    @Autowired
    private ValidDao dao;
    public int insertService(TodoRequestDTO params) {
        System.out.println("debug Todo Service insertService: " + params);
        TodoEntity entity = TodoEntity.builder()
                .title(params.getTitle())
                .content(params.getContent())
                .phone(params.getPhone())
                .startDate(params.getStartDate())
                .status(params.getStatus())
                .endDate(params.getEndDate())
                .priority(params.getPriority())
                .build();
        dao.save(entity);
        return 1;
    }
}