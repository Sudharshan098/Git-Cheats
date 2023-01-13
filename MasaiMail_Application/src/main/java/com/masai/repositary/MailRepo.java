package com.masai.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Email;


@Repository
public interface MailRepo extends JpaRepository<Email, Integer>{
	

}
