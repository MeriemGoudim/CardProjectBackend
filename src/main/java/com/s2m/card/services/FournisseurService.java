package com.s2m.card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.Fournisseur;
import com.s2m.card.repositories.FournisseurRepository;

@Component
public class FournisseurService {
	@Autowired
	private FournisseurRepository repository;
	
	public List<Fournisseur> getAllFournisseurs(){
		return (List<Fournisseur>) repository.findAll();
	}
	
	public Fournisseur create(Fournisseur fr) {
		return repository.save(fr);
	}
	
	public Optional<Fournisseur> getFournisseurById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	Fournisseur fournisseur=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id));
    	repository.delete(fournisseur);
    }
	
	public Fournisseur update(Long id,Fournisseur fr) throws ResourceNotFoundException {
    	Fournisseur fournisseur=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id));
		fournisseur.setNom(fr.getNom());
		fournisseur.setInfosCards(fr.getInfosCards());
		Fournisseur updatedFournisseur = repository.save(fournisseur);
    	return updatedFournisseur;
	}
}
