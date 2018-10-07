/* 
Author: Akshay Sehgal
Version: 1.1
Comments: Updated the Course class 
*/

package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.coursemanager.Views.View;
import javax.persistence.*;
import java.util.List;

/*
* @Entity : Used to Mark as Table for JPA
* */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {

	/*
	 * @JsonView : annotation added to fetch field by functions marked by same
	 * Interface Link:
	 * [https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in
	 * -spring]
	 */
	@JsonView(View.Summary.class)
	/* Mark as Id and auto Generated Field */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonView(View.Summary.class)
	// To Mark Column as Not Null
	@Column(nullable = false)
	private String name;

	@ManyToOne()
	@JsonIgnore
	private Faculty author;

	@OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Module> modules;

	// To include The Field in Serialization
	@JsonProperty
	public List<Module> getModules() {
		return modules;
	}

	// To Exclude The Field in Serialization
	@JsonIgnore
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
		if (!author.getAuthoredCourses().contains(this)) {
			author.getAuthoredCourses().add(this);
		}
	}

}
