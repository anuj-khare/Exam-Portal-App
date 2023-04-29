package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import com.exam.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class userController {
	
	
	
	
	@Autowired
	private UserService userService = new UserServiceImpl();
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);	
	}
	//Getting a user by username from the backend
	//returns null if no user with given username is found
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String userName) {
		return this.userService.getUser(userName);
	}
	
	//deleting a user by userid
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable("userid") Long userid) {
		this.userService.deleteUser(userid);
	}
	//update a user
//	@PutMapping("/{user}")
//	public User updateUser(@PathVariable("user") User user) {
//		this.userService.updateUser(user);
//	}
}
