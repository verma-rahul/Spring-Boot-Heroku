package com.project.coursemanager.services;
import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demo")
public class Demo {

    @GetMapping("/")
    public User demoFaculty() {
       return new Faculty("Jose-An", "jose-password", "Jose", "Annunziato","123 A",true);
    }
}
