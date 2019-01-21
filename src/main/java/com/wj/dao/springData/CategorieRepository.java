package com.wj.dao.springData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wj.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
}
