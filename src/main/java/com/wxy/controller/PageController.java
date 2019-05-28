package com.wxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/welcome1")
    public String welcome1(){
        return "welcome1";
    }

    @RequestMapping("/welcome2")
    public String welcome2(){
        return "welcome2";
    }
}
