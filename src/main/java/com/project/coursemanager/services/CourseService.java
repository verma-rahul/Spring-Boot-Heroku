package com.project.coursemanager.services;



import com.project.coursemanager.models.Course;
import com.project.coursemanager.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/")
    public Course createUser(@RequestBody Course course) {
        return courseRepository.save(course);
    }
}
