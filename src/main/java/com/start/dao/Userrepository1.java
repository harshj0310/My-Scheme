package com.start.dao;

import com.start.entities.Scheme;
import java.util.Optional;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository1 extends JpaRepository<Scheme,String>{
	Scheme deleteBysname(String sname);
	
	//update
	Optional<Scheme> findBysname(String sname);
}
