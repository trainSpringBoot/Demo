package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.spring.bean.category;

@Controller
public interface categoryDAO extends JpaRepository<category, String> {

}
