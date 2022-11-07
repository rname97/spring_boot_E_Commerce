package com.blackcode.project05.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class DashboardController {
    @GetMapping
    public String viewHomePage(){
        return "admin/index";
    }
}
