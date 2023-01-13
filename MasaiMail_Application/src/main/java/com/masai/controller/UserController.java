package com.masai.controller;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.Email;
import com.masai.models.User;
import com.masai.service.MailService;
import com.masai.service.UserService;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/masailmail")
public class UserController {
	
	@Autowired(required = true)
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerAdmin(@RequestBody User user) throws UserExecption {
		
		User saveAdmin = userService.registerUser(user);
		
		return new ResponseEntity<User>(saveAdmin,HttpStatus.CREATED);
		
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findAdminById(@PathVariable("id") Integer id) throws UserExecption{
		User user = userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("id") Integer id) throws UserExecption{
		String user = userService.deleteUserById(id);
		return new ResponseEntity<String>(user,HttpStatus.OK);
	}
	
}
