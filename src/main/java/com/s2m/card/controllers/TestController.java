package com.s2m.card.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('CHEF DE PROJET') or hasRole('CLIENT') or hasRole('IT') or hasRole('RESPONSABLE ACHAT') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/chefprojet")
    @PreAuthorize("hasRole('CHEF DE PROJET')")
    public String chefProjetAccess() {
        return "Chef de projet Board.";
    }
    
    @GetMapping("/it")
    @PreAuthorize("hasRole('IT')")
    public String itAccess() {
        return "IT Board.";
    }
    
    @GetMapping("/responsableachat")
    @PreAuthorize("hasRole('RESPONSABLE ACHAT')")
    public String moderatorAccess() {
        return "Responsable achat Board.";
    }
    
    @GetMapping("/client")
    @PreAuthorize("hasRole('CLIENT')")
    public String clientAccess() {
        return "Client Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
