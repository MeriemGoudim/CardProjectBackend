package com.s2m.card.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.s2m.card.models.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long>{

}
