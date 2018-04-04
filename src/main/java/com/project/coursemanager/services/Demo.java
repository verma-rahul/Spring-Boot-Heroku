package com.project.coursemanager.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class Demo {

    @GetMapping("/hello")
    public String findAllUsers() {
       return "Hello from Demo!";
    }
}
