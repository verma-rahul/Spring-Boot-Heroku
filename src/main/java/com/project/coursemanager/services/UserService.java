package com.project.coursemanager.services;


import com.project.coursemanager.models.User;
import com.project.coursemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;

	
	@GetMapping("/api/user")	
	public Iterable<User> findAllUsers(
			@RequestParam(name="username", required=false) String username,
			@RequestParam(name="password", required=false) String password) {
		if(username != null && password != null) {
			return userRepository.findUserByCredentials(username, password);
		} else if(username != null) {
			return userRepository.findUserByUsername(username);
		}
		Iterable<User> users=userRepository.findAll();
		return users;
	}
		
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int id) {
		return userRepository.findOne(id);
	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.delete(id);
	}

	@PutMapping("/api/user/{userId}")
	public User updateUser(
			@PathVariable("userId") int id,
			@RequestBody User newUser) {
		User user = userRepository.findOne(id);
		user.set(newUser);
		return userRepository.save(user);
	}
}
