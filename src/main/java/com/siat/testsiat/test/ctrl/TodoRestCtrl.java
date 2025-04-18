package com.siat.testsiat.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//API endpoint가 어떤 그룹에 속하는지를 알려주는 그룹핑 어노테이션
@Tag(name = "Todo API", description = "Todo 컨트롤러에 대한 설명입니다.")
@RequestMapping("/rest/todo")
public class TodoRestCtrl {
    @Autowired
    private TestService Service;
    // 데이터를 전달받는 ANNOTATION
    // @RequestParam : URL에서 전달받는 데이터
    // @PathValues : URL에서 전달받는 데이터
    @GetMapping("/registerForm")
    @Operation(summary = "등록 폼", description = "등록 페이지로 이동합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    public ResponseEntity<String> form() {
        System.out.println("debug Todo ctrl /registerForm");
        return new ResponseEntity<>("register", HttpStatus.OK);
    }
    
    // Endpoint URL : http://localhost:8088/todo/insert
    @PostMapping("/insert")
    @Operation(summary = "입력", description = "파라미터로 전달받은 정보를 저장합니다.")
    @Parameter(name= "title", description = "제목")
    @Parameter(name= "content", description = "내용")
    @Parameter(name= "status", description = "상태")
    @Parameter(name= "priority", description = "우선순위")
    @ApiResponse(responseCode = "200", description = "정상처리")
    @ApiResponse(responseCode = "501", description = "처리실패",
            content = @Content(schema = @Schema(implementation = TodoResponseDTO.class)))
    public ResponseEntity<String> insert(@RequestBody TodoRequestDTO params) {
        System.out.println("debug Todo ctrl /insert: " + params);
        int flag = Service.insertService(params);
        if (flag != 0) {
            return new ResponseEntity<>("정상처리", HttpStatus.OK);
        }
        return null;
    }
    // Endpoint URL : http://localhost:8088/todo/read?seq=1
    @GetMapping("/read")
    public ResponseEntity<TodoResponseDTO> read(@RequestParam("seq") int seq) {
        System.out.println("debug Todo ctrl /read: " + seq);
        TodoResponseDTO response = Service.selectService(seq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Endpoint URL : http://localhost:8088/todo/view/1
    @GetMapping("/view/{seq}")
    public ResponseEntity<TodoResponseDTO> view(@PathVariable("seq") int seq) {
        System.out.println("debug Todo ctrl /view/{seq} " + seq);
        TodoResponseDTO response = Service.selectService(seq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Endpoint URL : http://localhost:8088/todo/delete/1
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("seq") int seq) {
        System.out.println("debug Todo ctrl /delete?seq=" + seq);
        int flag = Service.deleteService(seq);
        if (flag != 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint URL : http://localhost:8088/todo/update
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestParam("title") String title,
                         @RequestParam("content") String content,
                         @RequestParam("status") String status,
                         @RequestParam("seq") int seq,
                         @RequestParam("priority") int priority) {
        System.out.println("debug Todo ctrl /update " + title + " " + content + " " + status + " " + seq);
        Map<String, Object> map= new HashMap<>();
        map.put("title", title);
        map.put("content", content);
        map.put("status", status);
        map.put("seq", seq);
        map.put("priority", priority);
        int flag = Service.updateService(map);
        if (flag != 0) {
            return new ResponseEntity<>("정상처리", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("비정상처리", HttpStatus.NOT_FOUND);
        }
        
    }
    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select() {
        System.out.println("debug Todo ctrl /select");
        List<TodoResponseDTO> list = Service.selectListService();
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK);
    }
}
