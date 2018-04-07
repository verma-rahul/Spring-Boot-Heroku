package com.project.coursemanager.services;


import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.Student;
import com.project.coursemanager.models.User;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FacultyService {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/faculty")
    public User createFaculty(@RequestBody Faculty faculty) {
        return userRepository.save(faculty);
    }

    @PutMapping("/api/faculty/{userId}")
    public User updateFaculty(
            @PathVariable("userId") int id,
            @RequestBody Faculty newFaculty) {
        User user = userRepository.findOne(id);
        user.set(newFaculty);
        return userRepository.save(user);
    }

}
