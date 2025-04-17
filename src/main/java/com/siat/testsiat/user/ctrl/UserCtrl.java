package com.siat.testsiat.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.user.model.domain.UserResponseDTO;
import com.siat.testsiat.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
@Slf4j
/*
trace:추적레벨
debug:디버깅 정보성 메시지 출력할 때
info:상태변경이나 정보성 메시지 출력할 때
warn:경고성 메시지 출력할 때
error:에러가 발생했을 때
 */
@Controller
@RequestMapping("/user")
public class UserCtrl {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService service;
    @PostMapping("/login")
    public String login(UserRequestDTO params) {
        log.info("debug User ctrl /login: " + params);
        UserResponseDTO response = service.loginService(params);
        log.debug("debug User ctrl /login: " + response);
        session.setAttribute("UserSession", response);
        return "redirect:/";
        
        
    }
    @GetMapping("/logout")
    public String logout() {
        log.info("debug User ctrl /logout");
        session.invalidate();
        return "redirect:/";
    }

}
