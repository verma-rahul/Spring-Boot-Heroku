package com.project.coursemanager.services;

import com.project.coursemanager.models.Course;
import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.Module;
import com.project.coursemanager.repositories.CourseRepository;
import com.project.coursemanager.repositories.ModuleRepository;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
public class ModuleService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;

    @PostMapping("/")
    public Module createModuleForCourse(@RequestBody Module module, @RequestParam(name="course_id", required=true) Integer courseId) {
        module.setCourse(courseRepository.findOne(courseId));
        return moduleRepository.save(module);
    }

    @PutMapping("/{moduleId}")
    public Module updateModuleName(@PathVariable("moduleId") int id,@RequestBody Module module) {
        Module newModule=moduleRepository.findOne(id);
        newModule.setName(module.getName());
        return moduleRepository.save(newModule);
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
