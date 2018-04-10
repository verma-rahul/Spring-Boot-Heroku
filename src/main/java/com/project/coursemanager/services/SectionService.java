package com.project.coursemanager.services;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.coursemanager.Views.View;
import com.project.coursemanager.models.Section;
import com.project.coursemanager.repositories.ModuleRepository;
import com.project.coursemanager.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionService {


        @Autowired
        SectionRepository sectionRepository;
        @Autowired
        ModuleRepository moduleRepository;

        @PostMapping("/")
        @JsonView(View.Summary.class)
        public Section createSectionForModule(@RequestBody Section section, @RequestParam(name="module_id", required=true) Integer moduleId) {
            section.setModule(moduleRepository.findOne(moduleId));
            return sectionRepository.save(section);
        }
        @JsonView(View.Summary.class)
        @PutMapping("/{sectionId}")
        public Section updateSectionName(@PathVariable("sectionId") int id,@RequestBody Section section) {
            Section newSection=sectionRepository.findOne(id);
            newSection.setName(section.getName());
            return sectionRepository.save(newSection);
        }
    /*   @JsonView : annotation added to fetch only
fields that are marked by same Interface in returned Entity Class
Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
        @JsonView(View.Summary.class)
        @GetMapping("/")
        public List<Section> getAllSections(@RequestParam(name="module_id", required=true) Integer moduleId) {
            return  moduleRepository.findOne(moduleId).getSections();

        }
    /*   @JsonView : annotation added to fetch only
fields that are marked by same Interface in returned Entity Class
Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
        @JsonView(View.Summary.class)
        @GetMapping("/{sectionId}")
        public Section getSectionById(@PathVariable("sectionId") int id) {
            return sectionRepository.findOne(id);

        }

        @DeleteMapping ("/{sectionId}")
        public void deleteModuleById(@PathVariable("sectionId") int id) {
            sectionRepository.delete(id);
        }

    }

