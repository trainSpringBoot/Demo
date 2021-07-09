package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.bean.users;


public interface usersDAO extends JpaRepository<users, String> {
	
}
