package com.thanh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanh.entity.*;

public interface CategoryDAO extends JpaRepository<Category, String>{
}
