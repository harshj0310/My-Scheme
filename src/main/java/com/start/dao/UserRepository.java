package com.start.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.smart.entities.Scheme;
//import com.smart.entities.Scheme;
import com.start.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
	//Optional<User> findByEmail(String email);
	User findByEmail(String email);
	
}
