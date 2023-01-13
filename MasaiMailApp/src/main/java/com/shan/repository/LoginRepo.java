package com.shan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shan.model.CurrentUserSession;


@Repository
public interface LoginRepo extends JpaRepository<CurrentUserSession, String> {
	
	
	public CurrentUserSession findByEmail(String mail);

	
	public CurrentUserSession findByUuid(String uuid);

 
}
