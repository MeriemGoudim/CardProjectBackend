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

import com.s2m.card.models.Fournisseur;
import com.s2m.card.services.FournisseurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FournisseurController {
	@Autowired
	private FournisseurService service;
	
	@GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFournisseurs() {
        return service.getAllFournisseurs();
    }
    @PostMapping("/fournisseurs")
    public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur) {
        return service.create(fournisseur);
    }
    @GetMapping("/fournisseurs/{id}")
    public Optional<Fournisseur> getFournisseurById(@PathVariable(required = true) long id) {
        return service.getFournisseurById(id);
    }
    @DeleteMapping("/fournisseurs/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/fournisseurs/{id}")
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Fournisseur fournisseur){
		final Fournisseur updatedFournisseur = service.create(fournisseur);
		return ResponseEntity.ok(updatedFournisseur);
	}
}
