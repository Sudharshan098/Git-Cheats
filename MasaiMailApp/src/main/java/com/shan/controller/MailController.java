package com.shan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shan.exception.MailNotFoundException;
import com.shan.model.Mail;
import com.shan.service.MasaiMailServe;

@RestController
@RequestMapping("/mail/masaimail")
public class MailController {
	@Autowired(required = true)
	private MasaiMailServe mmServe;
	
	
	@PostMapping("/mail")
	public ResponseEntity<Mail> createMail(@RequestBody Mail mail) throws MailNotFoundException{
		Email created = mmServe.createMail(mail);
		return new ResponseEntity<Email>(created,HttpStatus.CREATED);
	}
	
	@GetMapping("/mail")
	public ResponseEntity<Email> findMailByUserId(@PathVariable Integer id) throws MailNotFoundException{
		Email created = mailService.findMailByUserId(id);
		return new ResponseEntity<Email>(created,HttpStatus.CREATED);
	}
	
}
