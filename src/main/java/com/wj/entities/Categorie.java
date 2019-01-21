package com.wj.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String nomCategorie;
	//Une catégorie contient plusieurs produits
	//mappedBy : cela veut que l'aasociation est déjà décrite dans l'autre classe
	/*LAZY:Quand je demande à hibernate de charger une catégorie il ne va charger
	 * que les informations(id , nomCategorie), il ne va pas charger les produit
	 * de cette catégorie. Il ne va le charger qu'à la démande c'est à dire 
	 * ici en appelant la méthode getProduit
	 * Dans la classe produit une categorie est representée 
	 * par l'attribut categorie; donc il faut mettre mappedBy="categorie"
	 * */ 
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection<Produit> produits;

	
	public Categorie() {
		super();
	}


	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}


	public Collection<Produit> getProduits() {
		return produits;
	}


	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + "]";
	}

}
