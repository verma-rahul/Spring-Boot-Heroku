package com.project.coursemanager.services;


import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.Student;
import com.project.coursemanager.models.User;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentService {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/student")
    public User createStudent(@RequestBody Student student) {
        return userRepository.save(student);
    }

}
