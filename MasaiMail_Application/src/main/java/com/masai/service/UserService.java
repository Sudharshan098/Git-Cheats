package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.Email;
import com.masai.models.User;


public interface UserService {
	
	public User registerUser(User user) throws UserExecption;
	public User findUserById(Integer id) throws UserExecption;
	public String deleteUserById(Integer id) throws UserExecption;
	
	
	
}
