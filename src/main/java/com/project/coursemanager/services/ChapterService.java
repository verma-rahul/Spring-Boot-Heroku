package com.project.coursemanager.services;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.coursemanager.Views.View;
import com.project.coursemanager.models.Chapter;
import com.project.coursemanager.repositories.ModuleRepository;
import com.project.coursemanager.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapter")
public class ChapterService {


        @Autowired
        ChapterRepository chapterRepository;
        @Autowired
        ModuleRepository moduleRepository;

        @PostMapping("/")
        @JsonView(View.Summary.class)
        public Chapter createChapterForModule(@RequestBody Chapter chapter, @RequestParam(name="module_id", required=true) Integer moduleId) {
            chapter.setModule(moduleRepository.findOne(moduleId));
            return chapterRepository.save(chapter);
        }
        @JsonView(View.Summary.class)
        @PutMapping("/{chapterId}")
        public Chapter updateChapterName(@PathVariable("chapterId") int id,@RequestBody Chapter chapter) {
            Chapter newChapter= chapterRepository.findOne(id);
            newChapter.setName(chapter.getName());
            return chapterRepository.save(newChapter);
        }
    /*   @JsonView : annotation added to fetch only
fields that are marked by same Interface in returned Entity Class
Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
        @JsonView(View.Summary.class)
        @GetMapping("/")
        public List<Chapter> getAllChapters(@RequestParam(name="module_id", required=true) Integer moduleId) {
            return  moduleRepository.findOne(moduleId).getChapters();

        }
    /*   @JsonView : annotation added to fetch only
fields that are marked by same Interface in returned Entity Class
Link:  [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring]
*/
        @JsonView(View.Summary.class)
        @GetMapping("/{chapterId}")
        public Chapter getChapterById(@PathVariable("chapterId") int id) {
            return chapterRepository.findOne(id);

        }

        @DeleteMapping ("/{chapterId}")
        public void deleteChapterById(@PathVariable("chapterId") int id) {
            chapterRepository.delete(id);
        }

    }

