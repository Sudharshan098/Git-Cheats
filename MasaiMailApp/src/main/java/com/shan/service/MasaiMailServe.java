package com.shan.service;

import java.util.List;

import com.shan.exception.LoginException;
import com.shan.exception.MailNotFoundException;
import com.shan.exception.UserException;
import com.shan.model.CurrentUserSession;
import com.shan.model.LoginDTO;
import com.shan.model.Mail;
import com.shan.model.User;

public interface MasaiMailServe {
	
	
	
	public Mail createMail(Mail mail) throws MailNotFoundException;
	
	public Mail findMailByUserId(Integer id) throws MailNotFoundException;

	public User registerUser(User user) throws UserException;
	
	public User findUserById(Integer id) throws UserException;
	
	public String deleteUserById(Integer id) throws UserException;

}
