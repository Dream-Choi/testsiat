package com.siat.testsiat.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/bbs")

public class BbsCtrl {
    @GetMapping("/detail")
    public String getMethodName() {
        return new String();
    }
    
}
