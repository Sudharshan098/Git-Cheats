package com.shan.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Service;

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
public class Mail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mailId;
	private String subject;
	private LocalDateTime time;
	private String description;
	
	private boolean starred;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> userList = new ArrayList<>();
	

}
