package com.capgemini.entities;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "User_id", scope = Integer.class)
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int User_id;
	@Column(nullable = false, unique = true)
	private String User_name;
	@Column(nullable = false)
	private String User_email;
	@Column(nullable = false)
	private String User_mobile;
	@Column(nullable = false)
	private String User_password;
	@Column(nullable = false)
	private String User_type;

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="userdetails")
	private List<Enquiry>enquirylist;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="userdetails")
	private List<Vehicle>vehiclelist;
	

}