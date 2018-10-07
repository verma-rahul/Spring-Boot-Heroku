package com.project.coursemanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class WidgetHTML extends Widget {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // To Mark Column as Not Null
    @Column(nullable = false)
    private String content;

    public void set(WidgetHTML newWidget) {
        super.set(newWidget);
        this.content = newWidget.getContent() != null ? newWidget.getContent() : this.content;
    }
}
