package com.thanh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.thanh.dao.ProductDAO;
import com.thanh.entity.Product;
import com.thanh.entity.Report;

public interface ProductService {

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	Product getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Product> entities);

	Product getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Product entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> boolean exists(Example<S> example);

	<S extends Product> long count(Example<S> example);

	void deleteInBatch(Iterable<Product> entities);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	List<Product> saveAll(List<Product> entities);

	Optional<Product> findById(Integer id);

	List<Product> findAllById(Iterable<Integer> ids);

	List<Product> findAll(Sort sort);

	List<Report> getInventoryByCategory();

	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	<S extends Product> Optional<Product> findOne(Example<S> example);

	Product save(Product entity);

	List<Product> findByPrice(double minPrice, double maxPrice);

	Page<Product> findByKeywords(String keywords, Pageable pageable);


}
