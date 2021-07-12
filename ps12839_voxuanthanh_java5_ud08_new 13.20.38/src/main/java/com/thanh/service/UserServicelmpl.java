package com.thanh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanh.dao.AccountDAO;
import com.thanh.entity.Account;

@Service
public class UserServicelmpl implements UserService {

	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public Account save(Account entity) {
		return accountDAO.save(entity);
	}

	@Override
	public List<Account> saveAll(List<Account> entities) {
		return (List< Account >) accountDAO.saveAll(entities);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountDAO.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return accountDAO.existsById(id);
	}

	@Override
	public List<Account> findAll() {
		return (List < Account >) accountDAO.findAll();
	}

	@Override
	public List<Account> findAllById(List<String> ids) {
		return (List < Account >) accountDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return accountDAO.count();
	}

	@Override
	public void deleteById(String id) {
		accountDAO.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accountDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		accountDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		accountDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accountDAO.deleteAll();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Optional<Account> optionalUser = findById(username);
		if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
