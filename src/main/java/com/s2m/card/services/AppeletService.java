package com.s2m.card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.Appelet;
import com.s2m.card.repositories.AppeletRepository;

@Component
public class AppeletService {
	@Autowired
	AppeletRepository repository;
	
	public List<Appelet> getAllAppelets(){
		return (List<Appelet>) repository.findAll();
	}
	
	public Appelet create(Appelet appelet) {
		return repository.save(appelet);
	}
	
	public Optional<Appelet> getAppeletById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	Appelet appelet=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Appelet not found for this id :: " + id));
    	repository.delete(appelet);
    }
	
	public Appelet update(Long id,Appelet app) throws ResourceNotFoundException {
    	Appelet appelet=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Appelet not found for this id :: " + id));
		appelet.setNom(app.getNom());
		appelet.setScheimes(app.getScheimes());
		Appelet updatedAppelet = repository.save(appelet);
    	return updatedAppelet;
	}
}
