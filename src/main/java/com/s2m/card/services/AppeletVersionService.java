package com.s2m.card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.AppeletVersion;
import com.s2m.card.repositories.AppeletVersionRepository;

@Component
public class AppeletVersionService {
	@Autowired
	private AppeletVersionRepository repository;
	
	public List<AppeletVersion> getAllAppeletsVersions(){
		return (List<AppeletVersion>) repository.findAll();
	}
	
	public AppeletVersion create(AppeletVersion appeletVersion) {
		return repository.save(appeletVersion);
	}
	
	public Optional<AppeletVersion> getAppeletVersionById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	AppeletVersion appeletVersion=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("AppeletVersion not found for this id :: " + id));
    	repository.delete(appeletVersion);
    }
	
	public AppeletVersion update(Long id,AppeletVersion appV) throws ResourceNotFoundException {
    	AppeletVersion appeletVersion=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("AppeletVersion not found for this id :: " + id));
		appeletVersion.setNom(appV.getNom());
		appeletVersion.setAppelets(appV.getAppelets());
		AppeletVersion updatedAppeletVersion = repository.save(appeletVersion);
    	return updatedAppeletVersion;
	}
}
