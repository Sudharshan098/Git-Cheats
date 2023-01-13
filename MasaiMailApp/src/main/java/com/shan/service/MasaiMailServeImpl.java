package com.shan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shan.exception.MailNotFoundException;
import com.shan.exception.UserException;
import com.shan.model.Mail;
import com.shan.model.User;
import com.shan.repository.MailRepo;
import com.shan.repository.UserRepo;

@Service
public class MasaiMailServeImpl implements MasaiMailServe{

	@Autowired
	private MailRepo mRepo;
	
	@Autowired
	private UserRepo uRepo;




	@Override
	public User registerUser(User user) throws UserException {
		
		return uRepo.save(user);
	}


	@Override
	public User findUserById(Integer id) throws UserException {
		
		return uRepo.findById(id).orElseThrow(()->new UserExecption("Account does not found with id: "+id));
		
	}


	@Override
	public String deleteUserById(Integer id) throws UserException {
		
		String msg = "not found user";
		
		 Optional<User> find  = uRepo.findById(id);
		
		 if(find.isPresent()) {
			 uRepo.deleteById(id);
			 msg =  "Deleted Succesfully";
		 }
		 
		 return msg;
	}

	@Override
	public Mail createMail(Mail mail) throws MailNotFoundException {
		return mRepo.save(mail);
	}

	@Override
	public Mail findMailByUserId(Integer id) throws MailNotFoundException {
		Optional<User> find =  uRepo.findById(id);
		Mail mail = null;
		
		if(find.isPresent()) {
			mail = find.get().getEmail();
		}
		
		return mail;
	}

	

	
	
	
}
