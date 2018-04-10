package com.project.coursemanager.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class WidgetText extends Widget  {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //	To Mark Column as Not Null
    @Column(nullable = false)
    private String content;

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    //  Default Values use when Json does Not Provide value
    private String fontStyle="normal";
    private String fontType="monospace";
    private String fontSize="16px";
}
