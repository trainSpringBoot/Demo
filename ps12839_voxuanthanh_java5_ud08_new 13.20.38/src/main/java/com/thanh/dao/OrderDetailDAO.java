package com.thanh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanh.entity.*;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
}