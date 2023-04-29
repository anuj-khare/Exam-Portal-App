package com.exam.service;


import java.util.Set;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.UserRepository;

public interface UserService{
	//creating user 
	public User createUser(User user,Set<UserRole> roles) throws Exception;

	public User getUser(String userName);

	public void deleteUser(Long userid);

//	void updateUser(User user, Long userId);
}
