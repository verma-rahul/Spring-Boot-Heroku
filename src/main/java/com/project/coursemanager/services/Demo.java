package com.project.coursemanager.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demo")
public class Demo {

    @GetMapping("/")
    public String findAllUsers() {
       return "Hello from Spring Boot Server!";
    }
}
