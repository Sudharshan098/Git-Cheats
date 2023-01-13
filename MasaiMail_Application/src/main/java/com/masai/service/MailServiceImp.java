package com.masai.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.Email;
import com.masai.models.User;
import com.masai.repositary.MailRepo;
import com.masai.repositary.UserRepo;

import net.bytebuddy.implementation.bytecode.Throw;


@Service
public class MailServiceImp implements MailService{
	
	
	@Autowired
	private MailRepo mRepo;
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public Email createMail(Email mail) throws MailNotFoundException {
		return mRepo.save(mail);
	}

	@Override
	public Email findMailByUserId(Integer id) throws MailNotFoundException {
		
		Optional<User> find =  uRepo.findById(id);
		Email mail = null;
		
		if(find.isPresent()) {
			mail = find.get().getEmail();
		}
		
		return mail;
	}

	


}
