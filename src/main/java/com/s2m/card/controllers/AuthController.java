package com.s2m.card.controllers;

import com.s2m.card.models.Client;
import com.s2m.card.models.ERole;
import com.s2m.card.models.Role;
import com.s2m.card.models.User;
import com.s2m.card.payload.request.LoginRequest;
import com.s2m.card.payload.request.SignupRequest;
import com.s2m.card.payload.response.JwtResponse;
import com.s2m.card.payload.response.MessageResponse;
import com.s2m.card.repositories.ClientRepository;
import com.s2m.card.repositories.RoleRepository;
import com.s2m.card.repositories.UserRepository;
import com.s2m.card.security.jwt.JwtUtils;
import com.s2m.card.security.services.UserDetailsImpl;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    
    @Autowired
    ClientRepository clientRepo;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        
        Optional<Client> client = clientRepo.findById(userDetails.getId());
        
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles,client.isPresent() ? client.get() : null));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    	System.out.println("--------- create account");
    	System.out.println(signUpRequest);
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        ArrayList<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        
        if (strRoles == null) {
        	System.out.println("here");
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
        	System.out.println("deuxieme");
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "ROLE_CHEF_PROJET":
                        Role chefProjetRole = roleRepository.findByName(ERole.ROLE_CHEF_PROJET)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(chefProjetRole);
                    case "ROLE_IT":
                        Role itRole = roleRepository.findByName(ERole.ROLE_IT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(itRole);
                        break;
                    case "ROLE_RESPONSABLE_ACHAT":
                        Role responsableAchatRole = roleRepository.findByName(ERole.ROLE_RESPONSABLE_ACHAT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(responsableAchatRole);
                        break;
                    case "ROLE_CLIENT":
                        Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(clientRole);
                        
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        
        System.out.println(roles);
        user.setRoles(roles);
        user = userRepository.save(user);
        if(roles.contains(ERole.ROLE_CLIENT)) {
        	Optional<Client> client = clientRepo.findByLibcltc(user.getUsername().toUpperCase());
        	if(client.isPresent()) {
	        	client.get().setUser(user);
	        	clientRepo.save(client.get());
        	}
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
