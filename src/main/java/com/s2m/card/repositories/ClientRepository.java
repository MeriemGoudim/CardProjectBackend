package com.s2m.card.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s2m.card.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
	
}
