package com.project.coursemanager.services;

import com.project.coursemanager.models.*;
import com.project.coursemanager.repositories.ChapterRepository;
import com.project.coursemanager.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/widget")
public class WidgetService {

    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    WidgetRepository widgetRepository;

    @PostMapping("/")
    public Widget createWidgetForSection(@RequestBody Widget widget, @RequestParam(name="section_id", required=true) Integer sectionId) {

        widget.setChapter(chapterRepository.findOne(sectionId));
        return widgetRepository.save(widget);
    }

    @GetMapping("/")
    public Widget[] getAllWidgets(@RequestParam(name="section_id", required=true) Integer sectionId) {

        //		We Convert Iterable to Array, so that Jackson can find Type and use
        //		the Custom Configuration and add type field
        return StreamSupport.stream(chapterRepository.findOne(sectionId).
                                                getWidgets().spliterator(),
                                            false).toArray(Widget[]::new) ;

    }
    @GetMapping("/{widgetId}")
    public Widget getWidgetById(@PathVariable("widgetId") int id) {
        return widgetRepository.findOne(id);

    }

    @DeleteMapping ("/{widgetId}")
    public void deleteWidgetById(@PathVariable("widgetId") int id) {
        widgetRepository.delete(id);
    }

    @PutMapping("/{widgetId}")
    public Widget updateWidget(@PathVariable("widgetId") int id,@RequestBody Widget newWidget) {
        if (newWidget instanceof WidgetVideo){
            return updateWidgetVideo(id,newWidget);
        }
        else if (newWidget instanceof WidgetText){
            return updateWidgetText(id,newWidget);
        }
        else if (newWidget instanceof WidgetHTML){
            return updateWidgetHTML(id,newWidget);
        }
        else {
            return updateWidgetImage(id,newWidget);
        }

    }

    private Widget updateWidgetVideo(int id,Widget newWidget){
        WidgetVideo widget = (WidgetVideo) widgetRepository.findOne(id);
        widget.set((WidgetVideo) newWidget);
        return widgetRepository.save(widget);
    }
    private Widget updateWidgetText(int id,Widget newWidget){
        WidgetText widget = (WidgetText) widgetRepository.findOne(id);
        widget.set((WidgetText) newWidget);
        return widgetRepository.save(widget);
    }
    private Widget updateWidgetHTML(int id,Widget newWidget){
        WidgetHTML widget = (WidgetHTML) widgetRepository.findOne(id);
        widget.set((WidgetHTML) newWidget);
        return widgetRepository.save(widget);
    }
    private Widget updateWidgetImage(int id,Widget newWidget){
        WidgetImage widget = (WidgetImage) widgetRepository.findOne(id);
        widget.set((WidgetImage) newWidget);
        return widgetRepository.save(widget);
    }
}
