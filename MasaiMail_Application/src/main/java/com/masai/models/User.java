package com.masai.models;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	private String firstName;
	
	private String mobileNumber;
	
	@Past
	private Date dateOfBirth;
	
	@OneToOne
	private Email email;

	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Mail> mails = new HashSet<>();
	
	
	

	
}
