package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne()
	@JsonIgnore
	private Faculty author;
	public Course(String name) {
		super();
		this.name = name;
	}
	public Course() {
		super();
	}
	public Course(int id, String name) {
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
	public Faculty getAuthor() {
		return author;
	}
	public void setAuthor(Faculty author) {
		this.author = author;
		if(!author.getAuthoredCourses().contains(this)) {
			author.getAuthoredCourses().add(this);
		}
	}
}
