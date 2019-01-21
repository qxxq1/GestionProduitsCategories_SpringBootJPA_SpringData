package com.wj.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wj.entities.Produit;

@Repository
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Produit findOne(Long id) {
		Produit p = em.find(Produit.class, id);
		return p;
	}

	@Override
	public List<Produit> findAll() {
		Query req = em.createQuery("select p from Produit p");
		return req.getResultList(); //retourne la liste des produits
	}

	@Override
	public List<Produit> findByDesignation(String mc) {
		Query req = em.createQuery("select p from Produit p where p.designation like :x");
		req.setParameter("x", mc);
		return req.getResultList();
	}

	@Override
	public Produit save(Produit produit) {
		em.persist(produit);
		return produit;
	}

	@Override
	public Produit update(Produit produit) {
		em.merge(produit);
		return produit;
	}

	@Override
	public void delete(Long id) {
		Produit p = em.find(Produit.class, id);
		em.remove(p);
	}

}
