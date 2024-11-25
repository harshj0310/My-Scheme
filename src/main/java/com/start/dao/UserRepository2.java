package com.start.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.start.entities.Admin;
//import com.smart.entities.Scheme;
//import com.smart.entities.Scheme;
import com.start.entities.User;

public interface UserRepository2 extends JpaRepository<Admin,String>{
	//Optional<User> findByEmail(String email);
	Admin findByEmail(String email);
	
	
}
