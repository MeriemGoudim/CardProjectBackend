package com.s2m.card.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.Processus;
import com.s2m.card.repositories.ProcessusRepository;


@Component
public class ProcessusService {
	@Autowired
	private ProcessusRepository repository;
	
	public List<Processus> getAllProcessus(){
		return (List<Processus>) repository.findAll();
	}
	
	public Processus create(Processus pr) {
		Calendar c=Calendar.getInstance();
		c.setTime(pr.getDateDebut());
		c.add(Calendar.DAY_OF_MONTH, (int) (pr.getDelai1()+pr.getDelai2()+pr.getDelai3()));
		Date currentDate=c.getTime();
		pr.setDateFin(currentDate);
		return repository.save(pr);
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public Optional<Processus> getProcessusById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	Processus processus=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Processus not found for this id :: " + id));
    	repository.delete(processus);
    }
	
	public Processus update(Long id,Processus pr) throws ResourceNotFoundException {
    	Processus processus=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Processus not found for this id :: " + id));
		processus.setDateDebut(pr.getDateDebut());
		processus.setDelai1(pr.getDelai1());
		processus.setDelai2(pr.getDelai2());
		processus.setDelai3(pr.getDelai3());
		processus.setDateFin(pr.getDateFin());
		processus.setEtape(pr.getEtape());
		processus.setIsDisable(pr.getIsDisable());
		processus.setStatut(pr.getStatut());
		processus.setNamesFiles(pr.getNamesFiles());
		processus.setUser(pr.getUser());
		Processus updatedProcessus = repository.save(processus);
    	return updatedProcessus;
	}
}
