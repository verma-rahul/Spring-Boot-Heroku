package com.example.coursemanager;

import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.services.UserService;
import com.project.coursemanager.models.User;
import com.project.coursemanager.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void insertFaculty() {
		Faculty f1 = new Faculty("JGA", "webdev", "Jose", "annunziato", "123A", true);
		userService.createUser(f1);

	}
}
