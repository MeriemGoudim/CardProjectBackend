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

import com.s2m.card.models.Client;
import com.s2m.card.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@GetMapping("/clients")
    public List<Client> getAllClients() {
        return service.getAllClients();
    }
    @PostMapping("/clients")
    public Client create(@Valid @RequestBody Client client) {
        return service.create(client);
    }
    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable(required = true) long id) {
        return service.getClientById(id);
    }
    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Client client){
		final Client updatedClient = service.create(client);
		return ResponseEntity.ok(updatedClient);
	}
}
