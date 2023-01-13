package com.shan.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Service
public class User {
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String password;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateOfBirth;
	
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "userList")
	private List<Mail> maillist = new ArrayList<>();
	

}
