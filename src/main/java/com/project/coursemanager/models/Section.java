package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;



/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class Section {


    /* Mark as Id and auto Generated Field*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    //	To Mark Column as Not Null
    @Column(nullable = false)
    private String name;

    @ManyToOne()
    @JsonIgnore
    private Module module;


    @OneToMany(mappedBy = "section", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Widget> widgets;

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }


    public Section(String name) {
        super();
        this.name = name;
    }
    public Section() {
        super();
    }
    public Section(int id, String name) {
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
    public Module getModule() {
        return this.module;
    }
    public void setModule(Module module) {
        this.module = module;
        if(!module.getSections().contains(this)) {
            module.getSections().add(this);
        }
    }
}