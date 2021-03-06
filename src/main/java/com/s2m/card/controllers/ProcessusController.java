package com.s2m.card.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2m.card.models.Processus;
import com.s2m.card.services.ProcessusService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProcessusController {
	@Autowired
	private ProcessusService service;
	
	@GetMapping("/processus")
    public List<Processus> getAllProcessus() {
        return service.getAllProcessus();
    }
    @PostMapping("/processus")
    public Processus create(@Valid @RequestBody Processus processus) {
        return service.create(processus);
    }
    @GetMapping("/processus/{id}")
    public Optional<Processus> getProcessusById(@PathVariable(required = true) long id) {
        return service.getProcessusById(id);
    }
    @DeleteMapping("/processus/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/processus/{id}")
	public ResponseEntity<Processus> updateProcessus(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Processus processus){
		final Processus updatedProcessus = service.create(processus);
		return ResponseEntity.ok(updatedProcessus);
	}
}
