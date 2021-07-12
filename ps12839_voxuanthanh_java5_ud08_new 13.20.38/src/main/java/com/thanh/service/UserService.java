package com.thanh.service;

import java.util.List;
import java.util.Optional;



import com.thanh.entity.Account;


public interface UserService {


	void deleteAll();

	void deleteAll(Iterable<? extends Account> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Account entity);

	void deleteById(String id);

	long count();

	List<Account> findAllById(List<String> ids);

	List<Account> findAll();

	boolean existsById(String id);

	Optional<Account> findById(String id);

	List<Account> saveAll(List<Account> entities);

	Account save(Account entity);

	boolean checkLogin(String username, String password);
}
