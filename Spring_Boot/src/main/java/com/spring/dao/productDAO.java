package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bean.product;


public interface productDAO extends JpaRepository<product, String> {

}
