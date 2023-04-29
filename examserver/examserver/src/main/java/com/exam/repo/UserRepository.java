package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;


//Model-Type and Primary-key Type in generics
public interface UserRepository extends JpaRepository<User,Long>{
	public User findByUsername(String username); //Implementation is automatically given by spring-data-jpa
}
