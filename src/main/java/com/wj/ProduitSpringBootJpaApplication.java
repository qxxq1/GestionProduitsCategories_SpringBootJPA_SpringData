package com.wj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.wj.dao.EntityRepository;
import com.wj.dao.springData.CategorieRepository;
import com.wj.dao.springData.ProduitRepository;
import com.wj.entities.Categorie;
import com.wj.entities.Produit;

@SpringBootApplication
public class ProduitSpringBootJpaApplication {

	public static void main(String[] args) {
		
	ApplicationContext ctx = SpringApplication.run(ProduitSpringBootJpaApplication.class, args);
		/*@SuppressWarnings("unchecked")
		EntityRepository<Produit> produitDao = ctx.getBean(EntityRepository.class);
		produitDao.save(new Produit("LX456", 8000,7));
		produitDao.save(new Produit("HP 654", 500, 8));
		produitDao.save(new Produit("hp 786", 2000, 5));

		List<Produit> produits = produitDao.findAll();
		for(Produit p: produits)
		{
			System.out.println(p);
		}
		
		List<Produit> produits2 = produitDao.findByDesignation("%H%");
		for(Produit p: produits2)
		{
			System.out.println(p);
		}*/
	
	
	//Avec Spring DATA et la table Produit
	/*ProduitRepository produitDAO = ctx.getBean(ProduitRepository.class);
	produitDAO.save(new Produit("LX456", 8000,7));
	produitDAO.save(new Produit("HP 654", 500, 8));
	produitDAO.save(new Produit("hp 786", 2000, 5));

	List<Produit> produits = produitDAO.findAll();
	for(Produit p: produits)
	{
		System.out.println(p);
	}
	
	List<Produit> produits2 = produitDAO.findByDesignation("%H%");
	for(Produit p: produits2)
	{
		System.out.println(p);
	}
		*/
	
	
	
	//Avec Spring DATA et la Table Catégorie et Produit
	ProduitRepository produitDAO = ctx.getBean(ProduitRepository.class);
	CategorieRepository categorieDAO = ctx.getBean(CategorieRepository.class);
	
	Categorie c1 = new Categorie("Ordinateur");
	Categorie c2 = new Categorie("Imprimante");
	Categorie c3 = new Categorie("Logiciel");
	
	categorieDAO.save(c1);
	categorieDAO.save(c2);
	categorieDAO.save(c3);
	
	
	produitDAO.save(new Produit("LX456", 8000,7, c2));
	produitDAO.save(new Produit("HP 654", 500, 8, c2));
	produitDAO.save(new Produit("hp 786", 2000, 5, c3));


	List<Produit> produits = produitDAO.findAll();
	for(Produit p: produits)
	{
		System.out.println(p);
	}
	
	List<Produit> produits2 = produitDAO.findByDesignation("%H%");
	for(Produit p: produits2)
	{
		System.out.println(p);
	}

	}
	
}
