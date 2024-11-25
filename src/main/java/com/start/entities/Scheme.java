package com.start.entities;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="scheme")
//public class Scheme {
//@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
//  private int sid;
//  private String sname;
//  private String dept;
//  private String age;
//  private String link;
//  
//  
//  
// @ManyToOne
//  private User user;
//
//	public User getUser() {
//	return user;
//}
//public void setUser(User user) {
//	this.user = user;
//}
//	public int getSid() {
//		return sid;
//	}
//	public void setSid(int sid) {
//		this.sid = sid;
//	}
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public String getAge() {
//		return age;
//	}
//	public void setAge(String age) {
//		this.age = age;
//	}
//	public String getLink() {
//		return link;
//	}
//	public void setLink(String link) {
//		this.link = link;
//	}
//	public Scheme(int sid, String sname, String dept, String age, String link) {
//		super();
//		this.sid = sid;
//		this.sname = sname;
//		this.dept = dept;
//		this.age = age;
//		this.link = link;
//	}
//	   public Scheme() {
//		  super();
//		// TODO Auto-generated constructor stub
//	}
//}


import jakarta.persistence.Column;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="Newschemes")
//public class Scheme {
//	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column( name="s_id")
//	private int s_id;
//	@Id
//	@Column(name="sname")
//	private String sname;
//	@Column(name="s_department")
//	private String s_department;
//	@Column(name="s_income")
//	private String s_income;
//	@Column(name="s_age")
//	private int s_age;
//	@Column(name="s_link")
//	private String s_link;
//	@Column(name="s_gov")
//	private String s_gov;
//	public Scheme() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Scheme(int s_id, String sname, String s_department, int s_income, int s_age, String s_link, String s_gov) {
//		super();
//		this.s_id = s_id;
//		this.sname = sname;
//		this.s_department = s_department;
//		this.s_income = s_income;
//		this.s_age = s_age;
//		this.s_link = s_link;
//		this.s_gov = s_gov;
//	}
//	public int getS_id() {
//		return s_id;
//	}
//	public void setS_id(int s_id) {
//		this.s_id = s_id;
//	}
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getS_department() {
//		return s_department;
//	}
//	public void setS_department(String s_department) {
//		this.s_department = s_department;
//	}
//	public String getS_income() {
//		return s_income;
//	}
//	public void setS_income(String s_income) {
//		this.s_income = s_income;
//	}
//	public int getS_age() {
//		return s_age;
//	}
//	public void setS_age(int s_age) {
//		this.s_age = s_age;
//	}
//	public String getS_link() {
//		return s_link;
//	}
//	public void setS_link(String s_link) {
//		this.s_link = s_link;
//	}
//	public String getS_gov() {
//		return s_gov;
//	}
//	public void setS_gov(String s_gov) {
//		this.s_gov = s_gov;
//	}
//	@Override
//	public String toString() {
//		return "Scheme [s_id=" + s_id + ", s_name=" + sname + ", s_department=" + s_department + ", s_income="
//				+ s_income + ", s_age=" + s_age + ", s_link=" + s_link + ", s_gov=" + s_gov + "]";
//	}
//	
//	
//}

//*****************************************
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import jakarta.persistence.Table;
//
//
//
//@Entity
//@Table(name="new_scheme")
//public class Scheme {
//
//
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column( name="s_id")
//	private int s_id;
//	@Id
//	@Column(name="sname")
//	private String sname;
//	@Column(name="s_department")
//	private String s_department;
//	@Column(name="s_income")
//	private int s_income;
//	@Column(name="s_age")
//	private int s_age;
//	@Column(name="s_link")
//	private String s_link;
//	@Column(name="s_gov")
//	private String s_gov;
//	public Scheme() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Scheme( int s_id,String sname, String s_department, int s_income, int s_age, String s_link, String s_gov) {
//		super();
//		this.s_id=s_id;
//		this.sname = sname;
//		this.s_department = s_department;
//		this.s_income = s_income;
//		this.s_age = s_age;
//		this.s_link = s_link;
//		this.s_gov = s_gov;
//	}
//	
//	
//
//	public int getS_id() {
//		return s_id;
//	}
//	public void setSid(int s_id) {
//		this.s_id = s_id;
//	}
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getS_department() {
//		return s_department;
//	}
//	public void setS_department(String s_department) {
//		this.s_department = s_department;
//	}
//	public int getS_income() {
//		return s_income;
//	}
//	public void setS_income(int s_income) {
//		this.s_income = s_income;
//	}
//	public int getS_age() {
//		return s_age;
//	}
//	public void setS_age(int s_age) {
//		this.s_age = s_age;
//	}
//	public String getS_link() {
//		return s_link;
//	}
//	public void setS_link(String s_link) {
//		this.s_link = s_link;
//	}
//	public String getS_gov() {
//		return s_gov;
//	}
//	public void setS_gov(String s_gov) {
//		this.s_gov = s_gov;
//	}
//	@Override
//	public String toString() {
//		return "Scheme [sid=" + s_id + ", sname=" + sname + ", s_department=" + s_department + ", s_income=" + s_income
//				+ ", s_age=" + s_age + ", s_link=" + s_link + ", s_gov=" + s_gov + "]";
//	}
//	
//}




//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//
//import jakarta.persistence.Id;
//
//import jakarta.persistence.Table;
//
//
//
//@Entity
//@Table(name="s")
//public class Scheme {
//
//
//	
//	@Id
//	// @GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate generation strategy
//	@Column(name="sname")
//	private String sname;
//	@Column(name="s_department")
//	private String s_department;
//	@Column(name="s_income")
//	private int s_income;
//	@Column(name="s_age")
//	private int s_age;
//	@Column(name="s_link")
//	private String s_link;
//	@Column(name="s_gov")
//	private String s_gov;
//	public Scheme() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Scheme( String sname, String s_department, int s_income, int s_age, String s_link, String s_gov) {
//		super();
//		
//		this.sname = sname;
//		this.s_department = s_department;
//		this.s_income = s_income;
//		this.s_age = s_age;
//		this.s_link = s_link;
//		this.s_gov = s_gov;
//	}
//	
//	
//
//
//	
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getS_department() {
//		return s_department;
//	}
//	public void setS_department(String s_department) {
//		this.s_department = s_department;
//	}
//	public int getS_income() {
//		return s_income;
//	}
//	public void setS_income(int s_income) {
//		this.s_income = s_income;
//	}
//	public int getS_age() {
//		return s_age;
//	}
//	public void setS_age(int s_age) {
//		this.s_age = s_age;
//	}
//	public String getS_link() {
//		return s_link;
//	}
//	public void setS_link(String s_link) {
//		this.s_link = s_link;
//	}
//	public String getS_gov() {
//		return s_gov;
//	}
//	public void setS_gov(String s_gov) {
//		this.s_gov = s_gov;
//	}
//	@Override
//	public String toString() {
//		return "Scheme [ sname=" + sname + ", s_department=" + s_department + ", s_income=" + s_income
//				+ ", s_age=" + s_age + ", s_link=" + s_link + ", s_gov=" + s_gov + "]";
//	}
//	
//	
//}


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;



@Entity
@Table(name="ss")
public class Scheme {


//@GeneratedValue(strategy = GenerationType.IDENTITY) 	
 
  @Id
  private String sname;
  private String s_department;
  private int s_income;
  private String s_gender;
  private int s_age_min;
  private int s_age_max;
  private String s_caste;
  private String s_link;
	public Scheme( String sname, String s_department, int s_income, String s_gender, int s_age_min, int s_age_max,
			String s_caste, String s_link) {
		super();
		
		this.sname = sname;
		this.s_department = s_department;
		this.s_income = s_income;
		this.s_gender = s_gender;
		this.s_age_min = s_age_min;
		this.s_age_max = s_age_max;
		this.s_caste = s_caste;
		this.s_link = s_link;
	}
	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getS_department() {
		return s_department;
	}
	public void setS_department(String s_department) {
		this.s_department = s_department;
	}
	public int getS_income() {
		return s_income;
	}
	public void setS_income(int s_income) {
		this.s_income = s_income;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public int getS_age_min() {
		return s_age_min;
	}
	public void setS_age_min(int s_age_min) {
		this.s_age_min = s_age_min;
	}
	public int getS_age_max() {
		return s_age_max;
	}
	public void setS_age_max(int s_age_max) {
		this.s_age_max = s_age_max;
	}
	public String getS_caste() {
		return s_caste;
	}
	public void setS_caste(String s_caste) {
		this.s_caste = s_caste;
	}
	public String getS_link() {
		return s_link;
	}
	public void setS_link(String s_link) {
		this.s_link = s_link;
	}
	@Override
	public String toString() {
		return "Scheme [ sname=" + sname + ", s_department=" + s_department + ", s_income=" + s_income
				+ ", s_gender=" + s_gender + ", s_age_min=" + s_age_min + ", s_age_max=" + s_age_max + ", s_caste="
				+ s_caste + ", s_link=" + s_link + "]";
	}
  
	
  
}