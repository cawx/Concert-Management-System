package com.example.xo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
    @GetMapping("/")
    public String welcome() {
        return "home";
    }
    @GetMapping("/admin/home")
    public String welcomeAdmin() {
        return "admin home";
    }
    @GetMapping("/user/home")
    public String welcomeUser() {
        return "user home";
    }
}
