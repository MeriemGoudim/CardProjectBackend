package com.s2m.card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.Scheime;
import com.s2m.card.repositories.ScheimeRepository;

@Component
public class ScheimeService {
	@Autowired
	private ScheimeRepository repository;
	
	public List<String> getAllscheimesNames(){
		return repository.findAllScheimes();
	}
	
	public List<Scheime> getAllScheimes(){
		return (List<Scheime>) repository.findAll();
	}
	
	public Scheime create(Scheime scheime) {
		return repository.save(scheime);
	}
	
	public Optional<Scheime> getScheimeById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	Scheime scheime=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Scheime not found for this id :: " + id));
    	repository.delete(scheime);
    }
	
	public Scheime update(Long id,Scheime sc) throws ResourceNotFoundException {
    	Scheime scheime=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id));
		scheime.setNom(sc.getNom());
		scheime.setAppelet(sc.getAppelet());
		Scheime updatedScheime = repository.save(scheime);
    	return updatedScheime;
	}

}
