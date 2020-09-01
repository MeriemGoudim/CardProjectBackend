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
    
    @GetMapping("/infoscards/cardsclientc/{id}")
    public List<InfosCard> getInfosCardByClientAndStatutCloture(@PathVariable(required = true) long id) {
        return service.findByClientAndStatutCloture(id);
    }
    
    @GetMapping("/infoscards/cardscliente/{id}")
    public List<InfosCard> getInfosCardByClientAndStatutEnCours(@PathVariable(required = true) long id) {
        return service.findByClientAndStatutEncours(id);
    }
    
    @GetMapping("/infoscards/search/{bin}")
    public List<InfosCard> getInfosCardByBin(@PathVariable(required = true) String bin) {
        return service.getInfosCardsByBin(bin);
    }
    
    @GetMapping("/infoscards/search/{codeproduit}")
    public InfosCard getInfosCardByCodeProduit(@PathVariable(required = true) String codeproduit) {
        return service.getInfosCardsByCodeProduit(codeproduit);
    }
    
    @DeleteMapping("/infoscards/{id}")
    public Map<String, Boolean> delete(@PathVariable(required = true) long id) throws Exception {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
    
    @PutMapping("/infoscards/{idclient}/{idcard}")
    public ResponseEntity<InfosCard> updateCardByClientAndStatut(@PathVariable(value = "idclient") Long idclient, 
			@Valid @RequestBody String statut, @PathVariable(value = "idcard") Long idcard){
		final InfosCard updatedInfosCardByClientAndStatut = service.updateCardByStatutAndClient(statut, idclient, idcard);
		return ResponseEntity.ok(updatedInfosCardByClientAndStatut);
	}
    
    @PutMapping("/infoscards/{id}")
    public ResponseEntity<InfosCard> updateCardByEtat(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody String etat){
		final InfosCard updatedInfosCardByEtat = service.updateCardByEtat(etat, id);
		return ResponseEntity.ok(updatedInfosCardByEtat);
	}
    
    
    @PutMapping("/infoscards/{idcard}")
	public ResponseEntity<InfosCard> updateInfosCard(@PathVariable(value = "idcard") Long idcard,
			@Valid @RequestBody InfosCard infosCard){
		final InfosCard updatedInfosCard = service.create(infosCard);
		return ResponseEntity.ok(updatedInfosCard);
	}
}
