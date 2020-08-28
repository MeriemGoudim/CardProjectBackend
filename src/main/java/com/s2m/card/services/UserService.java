package com.s2m.card.services;

import com.s2m.card.models.User;
import com.s2m.card.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;



@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return (List<User>)repository.findAll();
    }

    public void create(User user) {
        repository.save(user);
    }

    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
}
