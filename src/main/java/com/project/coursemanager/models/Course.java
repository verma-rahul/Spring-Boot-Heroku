package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

/*
* @Entity : Used to Mark as Table for JPA
* */
@Entity
public class Course {

	/* Mark as Id and auto Generated Field*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	To Mark Column as Not Null
	@Column(nullable = false)
	private String name;

	@ManyToOne()
	@JsonIgnore
	private Faculty author;



	@OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

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
