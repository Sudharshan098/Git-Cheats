package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.Email;
import com.masai.service.MailService;
import com.masai.service.UserService;


@RestController
@RequestMapping("/masaimail")
public class MailController {
	
	@Autowired(required = true)
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	
	@PostMapping("/mail")
	public ResponseEntity<Email> createMail(@RequestBody Email mail) throws MailNotFoundException{
		Email created = mailService.createMail(mail);
		return new ResponseEntity<Email>(created,HttpStatus.CREATED);
	}
	
	@GetMapping("/mail")
	public ResponseEntity<Email> findMailByUserId(@PathVariable Integer id) throws MailNotFoundException{
		Email created = mailService.findMailByUserId(id);
		return new ResponseEntity<Email>(created,HttpStatus.CREATED);
	}
	
}
