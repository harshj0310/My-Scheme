package com.start.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="feedback")
public class Feedback {
	private String name;
	@Id
	private String email;
	private String feed;
	
	
	
	
	
	
	



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	@Override
	public String toString() {
		return "Feedback [name=" + name + ", email=" + email + ", feed=" + feed + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getFeed()=" + getFeed() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Feedback(String name, String email, String feed) {
		super();
		this.name = name;
		this.email = email;
		this.feed = feed;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
