package com.wj.dao;

import java.util.List;


public interface EntityRepository<T> {
	public T findOne(Long id);
	public List<T> findAll();
	public List<T> findByDesignation(String mc);
	public T save(T produit);
	public T update(T produit);
	public void delete(Long id);
}
