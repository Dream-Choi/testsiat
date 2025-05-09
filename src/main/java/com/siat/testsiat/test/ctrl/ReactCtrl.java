package com.siat.testsiat.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/react")
public class ReactCtrl {
    
    @Autowired
    private TestService service ;

    @GetMapping("/list")
    public ResponseEntity<List<TodoResponseDTO>> select() {
        System.out.println("debug >>> react ctrl /select "); 

        List<TodoResponseDTO> list =  service.selectListService();
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK) ;
    }
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>> react ctrl /login ");
        
        System.out.println("debug >>> react ctrl /login params : "+params); 
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<Void> delete(@PathVariable("seq") int seq) {
        System.out.println("debug Todo ctrl /delete?seq=" + seq);
        int flag = service.deleteService(seq);
        if (flag != 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/view/{seq}")
    public ResponseEntity<TodoResponseDTO> view(@PathVariable("seq") int seq) {
        System.out.println("debug Todo ctrl /view/{seq} " + seq);
        TodoResponseDTO response = service.selectService(seq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/read")
    public ResponseEntity<TodoResponseDTO> read(@PathVariable("seq") int seq) {
        System.out.println("debug Todo ctrl /read: " + seq);
        TodoResponseDTO response = service.selectService(seq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}