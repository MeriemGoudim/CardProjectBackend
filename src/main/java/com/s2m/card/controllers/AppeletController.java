package com.s2m.card.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2m.card.models.Appelet;
import com.s2m.card.services.AppeletService;

@RestController
@RequestMapping("/api/appelets")
public class AppeletController {
	@Autowired
	private AppeletService service;
	
	@GetMapping
    public List<Appelet> getAllAppelets() {
        return service.getAllAppelets();
    }
    @PostMapping
    public Appelet create(@Valid @RequestBody Appelet appelet) {
        return service.create(appelet);
    }
    @GetMapping("/{id}")
    public Optional<Appelet> getAppeletById(@PathVariable(required = true) long id) {
        return service.getAppeletById(id);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/{id}")
	public ResponseEntity<Appelet> updateAppelet(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Appelet appelet){
		final Appelet updatedAppelet = service.create(appelet);
		return ResponseEntity.ok(updatedAppelet);
	}
}
