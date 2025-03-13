package com.testapi.testapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // Ruta base
public class HomeController {

    @GetMapping("/")  // Endpoint: GET /api/hello
    public String index() {
        return "forward:/index.html";
    }
}