package com.project.coursemanager.services;


import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.Student;
import com.project.coursemanager.models.User;
import com.project.coursemanager.repositories.CourseRepository;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/common")
public class CommonService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @DeleteMapping ("/deleteAll")
    public void deletAll() {
        userRepository.deleteAll();
        courseRepository.deleteAll();
    }

}
