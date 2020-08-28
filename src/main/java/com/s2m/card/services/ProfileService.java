package com.s2m.card.services;

import com.s2m.card.models.Profile;
import com.s2m.card.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfileService {
    @Autowired
    private ProfileRepository repository;

    public List<Profile> getAllProfiles() {
        return (List<Profile>)repository.findAll();
    }

    public void create(Profile profile) {
        repository.save(profile);
    }

    public Optional<Profile> getProfileById(long id) {
        return repository.findById(id);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
}
