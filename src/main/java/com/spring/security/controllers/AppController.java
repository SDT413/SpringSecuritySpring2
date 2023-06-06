package com.spring.security.controllers;

import com.spring.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String showEmployees() {
        return "showEmployees";
    }
    @GetMapping("/hr_info")
    public String getInfoOnlyForHR() {
        return "view_for_hr";
    }
    @GetMapping("/manager_info")
    public String getInfoOnlyForManager() {
        return "view_for_manager";
    }
}
