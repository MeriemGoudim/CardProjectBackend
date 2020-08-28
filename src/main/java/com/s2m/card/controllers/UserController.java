package com.s2m.card.controllers;


import com.s2m.card.models.User;
import com.s2m.card.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    @PostMapping
    public void create(@RequestBody User user) {
        service.create(user);
    }
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable(required = true) long id) {
        return service.getUserById(id);
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}
