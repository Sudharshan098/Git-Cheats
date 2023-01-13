package com.shan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shan.exception.LoginException;
import com.shan.exception.MailNotFoundException;
import com.shan.exception.UserException;
import com.shan.model.CurrentUserSession;
import com.shan.model.LoginDTO;
import com.shan.model.Mail;
import com.shan.model.User;
import com.shan.service.MasaiMailServe;

@RestController
@RequestMapping("/user/masaimail")
public class UserController {

	
	@Autowired
	 private  MasaiMailServe mmServe;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		
		
		User savedUser =  mmServe.regUser(user);
		
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginUser(@RequestBody LoginDTO loginInfo) throws LoginException, UserException{
		
		
		CurrentUserSession cuserSession =  mmServe.loginUser(loginInfo);
		
		return new ResponseEntity<>(cuserSession,HttpStatus.CREATED);
	}
	

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException{
		
		User updatedUser =  mmServe.updateUser(user);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/mails")
	public ResponseEntity<List<Mail>> getAllMail() throws MailNotFoundException{
		
		List<Mail> mailList = mmServe.getAllMails();
		
		return new ResponseEntity<>(mailList,HttpStatus.OK);

	}
	
	
	@GetMapping("/starred")
	public ResponseEntity<List<Mail>> getAllStarred() throws MailNotFoundException{
		
		List<Mail> starredList = new ArrayList<>();
		
		List<Mail> mailList = mmServe.getAllMails();
		
		for(Mail m :mailList) {
			if(m.isStarred()) {
				starredList.add(m);
			}
		}
		
		return new ResponseEntity<>(starredList,HttpStatus.OK);

	}
	
	
}
