package com.project.coursemanager.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.coursemanager.models.Faculty;
import com.project.coursemanager.models.Student;
import com.project.coursemanager.models.User;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/user")
public class UserService {

	@Autowired
	UserRepository userRepository;

	
	@GetMapping("/")
	public User[] findAllUsers(
			@RequestParam(name="username", required=false) String username,
			@RequestParam(name="password", required=false) String password) {
		Iterable<User> users;
		if(username != null && password != null) {
			System.out.println(" in search by credentials");
			users= userRepository.findUserByCredentials(username, password);
		} else if(username != null) {
			System.out.println(" in search by username");
			users= userRepository.findUserByUsername(username);
		}else{
			users=userRepository.findAll();
		}
//		We Convert Iterable to Array, so that Jackson can find Type and use
//		the Custom Configuration and add type field
		return StreamSupport.stream(users.spliterator(), false).toArray(User[]::new);
	}
		
	@GetMapping("/{userId}")
	public User findUserById(@PathVariable("userId") int id) {
		return userRepository.findOne(id);
	}

	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.delete(id);
	}

	@PutMapping("/{userId}")
	public User updateUser(
			@PathVariable("userId") int id,
			@RequestBody User newUser) {

		if (newUser instanceof Faculty){
			return updateFaculty(id,newUser);
		}
		else{
			return updateStudent(id,newUser);
		}
	}

	private User updateFaculty(int id,User newUser){
		Faculty user = (Faculty) userRepository.findOne(id);
		user.set((Faculty) newUser);
		return userRepository.save(user);
	}
	private User updateStudent(int id,User newUser){
		Student user = (Student) userRepository.findOne(id);
		user.set((Student) newUser);
		return userRepository.save(user);
	}
}
