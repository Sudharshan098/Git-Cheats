package com.masai.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.DOMImplementationSource;

import com.masai.exception.MailNotFoundException;
import com.masai.exception.UserExecption;
import com.masai.models.User;
import com.masai.models.Email;
import com.masai.repositary.MailRepo;
import com.masai.repositary.UserRepo;

import net.bytebuddy.utility.RandomString;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired(required = true)
	private UserRepo aRepo; 
	
	
	@Autowired
	private MailRepo mRepo;

	@Override
	public User registerUser(User user) throws UserExecption {
		
		return aRepo.save(user);
	}


	@Override
	public User findUserById(Integer id) throws UserExecption {
		
		return aRepo.findById(id).orElseThrow(()->new UserExecption("Account does not found with id: "+id));
		
	}


	@Override
	public String deleteUserById(Integer id) throws UserExecption {
		
		String msg = "not found user";
		
		 Optional<User> find  = aRepo.findById(id);
		
		 if(find.isPresent()) {
			 aRepo.deleteById(id);
			 msg =  "Deleted Succesfully";
		 }
		 
		 return msg;
	}


}
