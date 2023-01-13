package com.shan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shan.model.CurrentUserSession;
import com.shan.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, String> {

	
	public User findByEmail(String email);

}
