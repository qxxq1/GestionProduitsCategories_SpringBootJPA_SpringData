package com.wj.dao;

import java.util.List;

import com.wj.entities.Produit;

public interface IProduitDao {
	public Produit findOne(Long id);
	public List<Produit> findAll();
	public List<Produit> findByDesignation(String mc);
	public Produit saveProduit(Produit produit);
	public Produit updateProduit(Produit produit);
	public void deleteProduit(Long id);
	
	
}
