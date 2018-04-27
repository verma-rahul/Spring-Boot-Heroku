package com.project.coursemanager.models;


import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class WidgetImage extends Widget  {

    //	To Mark Column as Not Null
    @Column(nullable = false)
    private String URL;

    private String width="320", height="240" ;

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


    public void set(WidgetImage newWidget){
        super.set(newWidget);
        this.URL = newWidget.getURL() != null ? newWidget.getURL() : this.URL;
        this.width = newWidget.getWidth() != null ? newWidget.getWidth() : this.width;
        this.height = newWidget.getHeight() != null ? newWidget.getHeight() : this.height;
    }
}
