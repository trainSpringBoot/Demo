package com.thanh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanh.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{
}
