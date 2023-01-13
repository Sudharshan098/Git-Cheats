package com.masai.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Email {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mailID;
	
	private String email;
	
	private Date created_date;
	
	@OneToOne
	private User user;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Set<User> users = new HashSet<>();

}
