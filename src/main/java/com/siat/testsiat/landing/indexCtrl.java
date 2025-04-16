package com.siat.testsiat.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexCtrl {
    @RequestMapping("/")
    public String index() {
        return "landing";
    }

}
