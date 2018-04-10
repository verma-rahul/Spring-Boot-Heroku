package com.project.coursemanager.services;

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
        public Section createSectionForModule(@RequestBody Section section, @RequestParam(name="module_id", required=true) Integer moduleId) {
            section.setModule(moduleRepository.findOne(moduleId));
            return sectionRepository.save(section);
        }

        @PutMapping("/{sectionId}")
        public Section updateSectionName(@PathVariable("sectionId") int id,@RequestBody Section section) {
            Section newSection=sectionRepository.findOne(id);
            newSection.setName(section.getName());
            return sectionRepository.save(newSection);
        }

        @GetMapping("/")
        public List<Section> getAllSections(@RequestParam(name="module_id", required=true) Integer moduleId) {
            return  moduleRepository.findOne(moduleId).getSections();

        }
        @GetMapping("/{sectionId}")
        public Section getSectionById(@PathVariable("sectionId") int id) {
            return sectionRepository.findOne(id);

        }

        @DeleteMapping ("/{sectionId}")
        public void deleteModuleById(@PathVariable("sectionId") int id) {
            sectionRepository.delete(id);
        }

    }

