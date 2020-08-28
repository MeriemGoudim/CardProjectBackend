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

import com.s2m.card.models.Scheime;
import com.s2m.card.services.ScheimeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ScheimeController {
	@Autowired
	private ScheimeService service;
	
	@GetMapping("/scheimes")
    public List<Scheime> getAllScheimes() {
        return service.getAllScheimes();
    }
	
	@GetMapping("/scheimes/scheimesnames")
    public List<String> getAllScheimesNames() {
        return service.getAllscheimesNames();
    }
	
    @PostMapping("/scheimes")
    public Scheime create(@Valid @RequestBody Scheime scheime) {
        return service.create(scheime);
    }
    @GetMapping("/scheimes/{id}")
    public Optional<Scheime> getScheimeById(@PathVariable(required = true) long id) {
        return service.getScheimeById(id);
    }
    @DeleteMapping("/scheimes/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/scheimes/{id}")
	public ResponseEntity<Scheime> updateScheime(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Scheime scheime){
		final Scheime updatedScheime = service.create(scheime);
		return ResponseEntity.ok(updatedScheime);
	}
}
