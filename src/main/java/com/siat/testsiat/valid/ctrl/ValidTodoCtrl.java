package com.siat.testsiat.valid.ctrl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.valid.service.ValidService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valid")
public class ValidTodoCtrl {
    @Autowired
    private ValidService Service;

    @PostMapping("/insert")
    public String insert(@Valid TodoRequestDTO params, BindingResult bindResult, Model model) {
        System.out.println("debug Todo ctrl /insert: " + params);
        List<ObjectError> vaildateErrors = bindResult.getAllErrors();
        if(bindResult.hasErrors()) {
            Map<String, String> map=new HashMap<>();
            for (int i = 0; i < vaildateErrors.size(); i++) {
                FieldError field = (FieldError) vaildateErrors.get(i);
                System.out.println("code: " + field.getCode());
                System.out.println("field: " + field.getField());
                System.out.println("message: " + field.getDefaultMessage());
                map.put(field.getField(), field.getDefaultMessage());
            }
            model.addAttribute("ValidError", map);
            return "register";
        } else{
            System.out.println("debug Todo ctrl /insert: " + params);
            int flag = Service.insertService(params);
        }
        return null;
    }
}
