package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;
import com.masai.model.Current_adminSession;

public interface adminSession extends JpaRepository<Current_adminSession, Integer> {
	public  Current_adminSession  findByUuid(String uuid);
}
