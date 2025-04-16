package com.siat.testsiat.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/todo")
public class TodoCtrl {
    @Autowired
    private TestService Service;
    // 데이터를 전달받는 ANNOTATION
    // @RequestParam : URL에서 전달받는 데이터
    // @PathValues : URL에서 전달받는 데이터
    @GetMapping("/registerForm")
    public String form() {
        System.out.println("debug Todo ctrl /registerForm");
        return "register";
    }
    // Endpoint URL : http://localhost:8088/todo/insert
    @PostMapping("/insert")
    public String insert(TodoRequestDTO params) {
        System.out.println("debug Todo ctrl /insert: " + params);
        int flag = Service.insertService(params);
        if (flag != 0) {
            return "redirect:/";
        } else {
            return "xxxxx";
        }
    }
    // Endpoint URL : http://localhost:8088/todo/read?seq=1
    @GetMapping("/read")
    public String read(@RequestParam int seq, Model model) {
        System.out.println("debug Todo ctrl /read: " + seq);
        TodoResponseDTO response = Service.selectService(seq);
        model.addAttribute("read", response);
        return "read";
    }
    // Endpoint URL : http://localhost:8088/todo/view/1
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") int seq, Model model) {
        System.out.println("debug Todo ctrl /view/{seq} " + seq);
        TodoResponseDTO response = Service.selectService(seq);
        model.addAttribute("read", response);
        return "read";
    }
    // Endpoint URL : http://localhost:8088/todo/delete/1
    @GetMapping("/delete")
    public String delete(@RequestParam int seq) {
        System.out.println("debug Todo ctrl /delete/{seq} " + seq);
        int flag = Service.deleteService(seq);
        if (flag != 0) {
            return "redirect:/todo/select";
        } else {
            return "xxxxx";
        }
    }
    // Endpoint URL : http://localhost:8088/todo/update
    @PostMapping("/update")
    public String update(@RequestParam String title,
                         @RequestParam String content,
                         @RequestParam String status,
                         @RequestParam int seq,
                         @RequestParam int priority) {
        System.out.println("debug Todo ctrl /update " + title + " " + content + " " + status + " " + seq);
        Map<String, Object> map= new HashMap<>();
        map.put("title", title);
        map.put("content", content);
        map.put("status", status);
        map.put("seq", seq);
        map.put("priority", priority);
        int flag = Service.updateService(map);
        if (flag != 0) {
            return "redirect:/todo/select";
        } else {
            return "xxxxx";
        }
        
    }
    @GetMapping("/select")
    public String select(Model model) {
        System.out.println("debug Todo ctrl /select");
        List<TodoResponseDTO> list = Service.selectListService();
        model.addAttribute("list", list);
        return "list";
    }
    
    
    
}
