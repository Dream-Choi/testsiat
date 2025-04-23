package com.siat.testsiat.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;
import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.valid.service.ValidService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/react")
public class ReactCtrl {
    
    @Autowired
    private TestService service ;

    @PostMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoRequestDTO params) {
        System.out.println("debug >>> react ctrl /select ");
        
        System.out.println("debug >>> react ctrl /select params : "+params); 

        List<TodoResponseDTO> list =  service.selectListService();
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK) ;
    }
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>> react ctrl /login ");
        
        System.out.println("debug >>> react ctrl /login params : "+params); 
        return ResponseEntity.ok().build();
    }
}