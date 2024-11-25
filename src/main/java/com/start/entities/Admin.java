package com.start.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
//@Table(name="Newuser")
@Table(name="admin")
public class Admin {

	
	@NotBlank
	private String name;
	@Column(unique=true)
	@Id
	private String email;
	private String password;
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Scheme> schemes=new ArrayList<>();
	
	
	
	
	
	public List<Scheme> getSchemes() {
		return schemes;
	}



	public void setSchemes(List<Scheme> schemes) {
		this.schemes = schemes;
	}



	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Admin( String name, String email, String password, String role, boolean enable) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}





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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	



	@Override
	public String toString() {
		return "User [ name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
		
}
