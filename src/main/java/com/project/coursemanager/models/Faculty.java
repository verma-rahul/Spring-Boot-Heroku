package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Faculty extends User {
	private String office;
	private Boolean tenure;
	@OneToMany(mappedBy="author")
	@JsonIgnore
	private List<Course> authoredCourses;
	public void authoredCourse(Course course) {
		this.authoredCourses.add(course);
		if(course.getAuthor() != this) {
			course.setAuthor(this);
		}
	}
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	public Faculty() {
		super();
	}
	public Faculty(String username, String password, String firstName, String lastName, String office, Boolean tenure) {
		super(username, password, firstName, lastName);
		this.office = office;
		this.tenure = tenure;
	}
	public Faculty(String office, Boolean tenure) {
		super();
		this.office = office;
		this.tenure = tenure;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenure;
	}
	public void setTenure(Boolean tenure) {
		this.tenure = tenure;
	}
}
