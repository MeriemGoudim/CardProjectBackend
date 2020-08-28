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

import com.s2m.card.models.AppeletVersion;
import com.s2m.card.services.AppeletVersionService;

@RestController
@RequestMapping("/api/appeletsversions")
public class AppeletVersionController {
	@Autowired
	AppeletVersionService service;
	
	@GetMapping
    public List<AppeletVersion> getAllAppeletsVersions() {
        return service.getAllAppeletsVersions();
    }
    @PostMapping
    public AppeletVersion create(@Valid @RequestBody AppeletVersion appeletVersion) {
        return service.create(appeletVersion);
    }
    @GetMapping("/{id}")
    public Optional<AppeletVersion> getAppeletVersionById(@PathVariable(required = true) long id) {
        return service.getAppeletVersionById(id);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    @PutMapping("/{id}")
	public ResponseEntity<AppeletVersion> updateAppeletVersion(@PathVariable(value = "id") Long id,
			@Valid @RequestBody AppeletVersion appeletVersion){
		final AppeletVersion updatedAppeletVersion = service.create(appeletVersion);
		return ResponseEntity.ok(updatedAppeletVersion);
	}
}
