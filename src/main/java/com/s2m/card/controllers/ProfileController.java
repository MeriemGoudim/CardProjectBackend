package com.s2m.card.controllers;


import com.s2m.card.models.Profile;
import com.s2m.card.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    ProfileService service;
    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }
    @PostMapping
    public void create(@RequestBody Profile profile) {
        service.create(profile);
    }
    @GetMapping("/{id}")
    public Optional<Profile> getById(@PathVariable(required = true) long id) {
        return service.getProfileById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}
