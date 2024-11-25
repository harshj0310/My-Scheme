package com.start.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.start.entities.Feedback;
import com.start.entities.Scheme;
@Repository
public interface UserRepositoryfeed extends JpaRepository<Feedback,String> {
	
	
		
	}


