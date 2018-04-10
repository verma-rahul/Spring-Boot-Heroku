package com.project.coursemanager.services;

import com.project.coursemanager.models.Course;
import com.project.coursemanager.models.CoursePageWrapper;
import com.project.coursemanager.models.Module;
import com.project.coursemanager.repositories.CourseRepository;
import com.project.coursemanager.repositories.ModuleRepository;
import com.project.coursemanager.repositories.SectionRepository;
import com.project.coursemanager.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coursepage")
public class CoursePageService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    WidgetRepository widgetRepository;

   /* @GetMapping("/{courseId}")
    public CoursePageWrapper getCourseById(@PathVariable("courseId") int id) {
        CoursePageWrapper coursePage=new CoursePageWrapper();
        return courseRepository.findOne(id);
    }*/

}
