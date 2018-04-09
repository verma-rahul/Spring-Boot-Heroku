package com.project.coursemanager.services;



import com.project.coursemanager.models.Course;
import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.repositories.CourseRepository;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/")
    public Course createCourseForUser(@RequestBody Course course, @RequestParam(name="user_id", required=true) Integer userId) {
        course.setAuthor((Faculty) userRepository.findOne(userId));
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourseName(@PathVariable("courseId") int id,@RequestBody Course course) {
        Course newCourse=courseRepository.findOne(id);
        newCourse.setName(course.getName());
        return courseRepository.save(newCourse);
    }

    @GetMapping("/")
    public List<Course> getAllCourses(@RequestParam(name="user_id", required=true) Integer userId) {
        return ((Faculty) userRepository.findOne(userId)).getAuthoredCourses();

    }
    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int id) {
        return courseRepository.findOne(id);

    }

    @DeleteMapping ("/{courseId}")
    public void deleteCourseById(@PathVariable("courseId") int id) {
        courseRepository.delete(id);
    }
}
