package com.wj.dao.springData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wj.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query("select p from Produit p where p.designation like :x")
	List<Produit> findByDesignation(@Param("x")String mc);
}
