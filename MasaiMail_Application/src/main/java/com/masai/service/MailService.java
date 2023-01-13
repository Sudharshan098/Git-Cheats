package com.masai.service;

import java.util.List;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.Email;

public interface MailService {
	
	public Email createMail(Email mail) throws MailNotFoundException;
	
	public Email findMailByUserId(Integer id) throws MailNotFoundException;
}
