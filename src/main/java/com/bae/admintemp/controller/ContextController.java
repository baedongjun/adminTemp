package com.bae.admintemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.Context;

@Controller
public class ContextController {

    @RequestMapping("/")
    public String context(Context context) {
        context.setVariable("message", "Hello, Thymeleaf!");
        return "context";
    }

}
