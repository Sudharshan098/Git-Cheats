package com.shan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shan.model.Mail;


@Repository
public interface MailRepo extends JpaRepository<Mail, Integer> {

}
