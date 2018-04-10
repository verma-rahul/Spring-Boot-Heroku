package com.project.coursemanager.models;

import java.util.ArrayList;
import java.util.List;

public class CoursePageWrapper {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModuleWrapper> getModules() {
        return modules;
    }

    public void setModules(List<ModuleWrapper> modules) {
        this.modules = modules;
    }

    private List<ModuleWrapper> modules;
    public void set(Course course){
//        id=course.getId();
//        name=course.getName();
//        modules=new ArrayList<>();
//        List<Module> modulesUnwrapped= course.getModules();
//        ModuleWrapper moduleWrapper;
//        for(Module unWrappedModule: modulesUnwrapped){
//           moduleWrapper=new ModuleWrapper();
//           moduleWrapper.set(unWrappedModule);
//            modules
//        }

    }
}


/*    private void setCourse(CoursePageWrapper coursePage,Course course){
        coursePage.setId(course.getId());
        coursePage.setName(course.getName());


    }
    private void setModules(CoursePageWrapper coursePage, List<Module> modules){
        ModuleWrapper addModule;
        for (Module module : modules){
            addModule=new Module();
            addModulecourseRepository.findOne(id);
        }

    }
    private void setSections(CoursePageWrapper coursePage,Course course){

    }*/


class ModuleWrapper {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SectionWrapper> getSections() {
        return sections;
    }

    public void setSections(List<SectionWrapper> sections) {
        this.sections = sections;
    }

    private List<SectionWrapper> sections;
}
class SectionWrapper {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    private List<Widget> widgets;
}