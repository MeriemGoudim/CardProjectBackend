package com.s2m.card.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.s2m.card.models.Scheime;

@Repository
public interface ScheimeRepository extends CrudRepository<Scheime, Long>{
	@Query(value="select s.nom from Scheime s")
	List<String> findAllScheimes();
}