package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

//whenever a class follows some interface,we have to specify that using implements keyword
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	//Creating user
	@Override
	public User createUser(User user,Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User is already present");
			throw new Exception("User already present");
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUsername(userName);
	}

	@Override
	public void deleteUser(Long userid) {
		this.userRepository.deleteById(userid);
		
	}

	
}
