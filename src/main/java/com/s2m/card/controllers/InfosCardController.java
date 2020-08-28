package com.s2m.card.controllers;

import com.s2m.card.models.InfosCard;
import com.s2m.card.services.InfosCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InfosCardController {
    @Autowired
    InfosCardService service;
    
    @GetMapping("/infoscards")
    public List<InfosCard> getAllCards() {
        return service.getAllInfosCards();
    }
    @PostMapping("/infoscards")
    public InfosCard create(@Valid @RequestBody InfosCard infoscard) {
        return service.create(infoscard);
    }
    @GetMapping("/infoscards/{id}")
    public Optional<InfosCard> getInfosCardById(@PathVariable(required = true) long id) {
        return service.getInfosCardById(id);
    }
    @DeleteMapping("/infoscards/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/infoscards/{id}")
	public ResponseEntity<InfosCard> updateInfosCard(@PathVariable(value = "id") Long id,
			@Valid @RequestBody InfosCard infosCard){
		final InfosCard updatedInfosCard = service.create(infosCard);
		return ResponseEntity.ok(updatedInfosCard);
	}
}
