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

public class ProductServiceImpl implements ProductService{


	@Autowired
	ProductDAO productDAO;
	
	@Override
	public Page<Product> findByKeywords(String keywords, Pageable pageable) {
		return productDAO.findByKeywords(keywords, pageable);
	}

	@Override
	public List<Product> findByPrice(double minPrice, double maxPrice) {
		return productDAO.findByPrice(minPrice, maxPrice);
	}

	@Override
	public Product save(Product entity) {
		return productDAO.save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Product> Optional<Product> findOne(Example<S> example) {
		return (Optional<Product>) productDAO.findOne(example);
	}

	@Override
	public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
		return productDAO.findByPriceBetween(minPrice, maxPrice);
	}

	@Override
	public Page<Product> findAllByNameLike(String keywords, Pageable pageable) {
		return productDAO.findAllByNameLike(keywords, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDAO.findAll(pageable);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productDAO.findAll();
	}

	@Override
	public List<Report> getInventoryByCategory() {
		return productDAO.getInventoryByCategory();
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return  productDAO.findAll(sort);
	}

	@Override
	public List<Product> findAllById(Iterable<Integer> ids) {
		return productDAO.findAllById(ids);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productDAO.findById(id);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>)productDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		productDAO.flush();
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDAO.existsById(id);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productDAO.findAll(example, pageable);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productDAO.count(example);
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		productDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		productDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productDAO.deleteAllInBatch();
	}

	@Override
	public Product getOne(Integer id) {
		return productDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDAO.deleteAll();
	}

	@Override
	public Product getById(Integer id) {
		return productDAO.getById(id);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productDAO.findAll(example);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		return productDAO.findAll(example, sort);
	}
	
	
}
