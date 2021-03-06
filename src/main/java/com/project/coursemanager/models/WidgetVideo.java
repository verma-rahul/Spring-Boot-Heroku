package com.project.coursemanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class WidgetVideo extends Widget {
    //	To Mark Column as Not Null
    @Column(nullable = false)
    private String URL;

    private String width="320", height="240" ;
    Boolean controls=true;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Boolean getControls() {
        return controls;
    }

    public void setControls(Boolean controls) {
        this.controls = controls;
    }
    public void set(WidgetVideo newWidget){
        super.set(newWidget);
        this.URL = newWidget.getURL() != null ? newWidget.getURL() : this.URL;
        this.width = newWidget.getWidth() != null ? newWidget.getWidth() : this.width;
        this.height = newWidget.getHeight() != null ? newWidget.getHeight() : this.height;
        this.controls = newWidget.getControls() != null ? newWidget.getControls() : this.controls;
    }


}
