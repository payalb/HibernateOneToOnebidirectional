package com.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//map to the table in the db
@Entity
public class Student {
	//primary key column
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	@Column(name="stName",unique=true)
	private String name;
	@OneToOne
	@JoinColumn(name="passportId")
	//In student table, it will store the passport id: passport_passportid
	private Passport passport;
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Student(int id, String name, Passport address) {
		super();
		this.id = id;
		this.name = name;
		this.passport = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + passport + "]";
	}
	public Student() {
		super();
		//This is mandatory when hibernate is retrieving objects from db
	}
}
