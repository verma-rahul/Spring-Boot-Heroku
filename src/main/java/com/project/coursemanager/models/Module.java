package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;



/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class Module {


    /* Mark as Id and auto Generated Field*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    //	To Mark Column as Not Null
    @Column(nullable = false)
    private String name;

    @ManyToOne()
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "module", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Section> sections;
    //    To include The Field in Serialization
    @JsonProperty
    public List<Section> getSections() {
        return sections;
    }
    //    To Exclude The Field in Serialization
    @JsonIgnore
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Module(String name) {
        super();
        this.name = name;
    }
    public Module() {
        super();
    }
    public Module(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
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
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
        if(!course.getModules().contains(this)) {
            course.getModules().add(this);
        }
    }
}
