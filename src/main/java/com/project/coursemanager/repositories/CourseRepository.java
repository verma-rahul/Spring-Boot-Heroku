package com.project.coursemanager.repositories;

import com.project.coursemanager.models.Course;
import com.project.coursemanager.models.User;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository  extends CrudRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.name=:name")
    Iterable<Course> findCourseByName(@Param("name") String name);

}
