package com.services.gestion_projets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TacheMembreRepository extends JpaRepository<TacheMembre, String> {

	@Query(
	        value = "SELECT * FROM tache_membre WHERE MATCH(tache, membre) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Projet> search_data(String keyword);
	@Query(
	        value = "SELECT count(id) from tache_membre;",
	        nativeQuery = true)
	    public String n_b_data();
}
