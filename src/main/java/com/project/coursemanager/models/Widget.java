package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.List;


/*
 * @Entity : Used to Mark as Table for JPA
 *
 * @JsonTypeInfo : Tells the superClass User to AutoCast to Student or Faculty depending upon type property
 * [https://stackoverflow.com/questions/27170298/spring-reponsebody-requestbody-with-abstract-class  ]
 *
 * @Inheritance(strategy = "") : Tells the Inheritance Strategy to use, see below link
 * https://www.thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/
 * */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = WidgetHTML.class, name = "HTML"),
        @JsonSubTypes.Type(value = WidgetImage.class, name = "IMAGE"),
        @JsonSubTypes.Type(value = WidgetText.class, name = "TEXT"),
        @JsonSubTypes.Type(value = WidgetVideo.class, name = "VIDEO") })
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Widget {

        /* Mark as Id and auto Generated Field*/
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
        //	To Mark Column as Not Null
        @Column(nullable = false)
        private String name;

        @ManyToOne()
        @JsonIgnore
        private Section section;


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
        public Section getSection() {
            return this.section;
        }
        public void setSection(Section section) {
            this.section = section;
            if(!section.getWidgets().contains(this)) {
                section.getWidgets().add(this);
            }
        }

}
