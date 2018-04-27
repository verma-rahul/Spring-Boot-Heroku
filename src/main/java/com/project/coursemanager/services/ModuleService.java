package com.project.coursemanager.services;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.coursemanager.Views.View;
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

    /*   @JsonView : annotation added to fetch only
  fields that are marked by same Interface in returned Entity Class
  Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
    @JsonView(View.Summary.class)
    @PostMapping("/")
    public Module createModuleForCourse(@RequestBody Module module, @RequestParam(name="course_id", required=true) Integer courseId) {
        module.setCourse(courseRepository.findOne(courseId));
        return moduleRepository.save(module);
    }

    /*   @JsonView : annotation added to fetch only
  fields that are marked by same Interface in returned Entity Class
  Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
    @JsonView(View.Summary.class)
    @PutMapping("/{moduleId}")
    public Module updateModuleName(@PathVariable("moduleId") int id,@RequestBody Module module) {
        Module newModule=moduleRepository.findOne(id);
        newModule.setName(module.getName());
        return moduleRepository.save(newModule);
    }

    /*   @JsonView : annotation added to fetch only
  fields that are marked by same Interface in returned Entity Class
  Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
    @JsonView(View.Summary.class)
    @GetMapping("/")
    public List<Module> getAllModules(@RequestParam(name="course_id", required=true) Integer courseId) {
        return  courseRepository.findOne(courseId).getModules();

    }


    /*   @JsonView : annotation added to fetch only
    fields that are marked by same Interface in returned Entity Class
    Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
    @JsonView(View.Summary.class)
    @GetMapping("/{moduleId}")
    public Module getModuleById(@PathVariable("moduleId") int id) {
        return moduleRepository.findOne(id);

    }

    @DeleteMapping ("/{moduleId}")
    public void deleteModuleById(@PathVariable("moduleId") int id) {
        moduleRepository.delete(id);
    }

}
