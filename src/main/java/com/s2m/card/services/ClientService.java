package com.s2m.card.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.Client;
import com.s2m.card.repositories.ClientRepository;

@Component
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> getAllClients(){
		return (List<Client>) repository.findAll();
	}
	
	public Client create(Client clt) {
		return repository.save(clt);
	}
	
	public Optional<Client> getClientById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
    	Client client=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
    	repository.delete(client);
    }
	
	public Client update(Long id,Client clt) throws ResourceNotFoundException {
    	Client client=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		client.setCdclt(clt.getCdclt());
		client.setFaxclt1(clt.getFaxclt1());
		client.setFaxclt2(clt.getFaxclt2());
		client.setInfosCards(clt.getInfosCards());
		client.setLibcltc(clt.getLibclte());
		client.setLibclte(clt.getLibclte());
		client.setTpclt(clt.getTpclt());
		client.setNbtrcpt(clt.getNbtrcpt());
		client.setObsclt(clt.getObsclt());
		client.setOrdchm(clt.getOrdchm());
		client.setPayclt(clt.getPayclt());
		client.setRueclt1(clt.getRueclt1());
		client.setRueclt2(clt.getRueclt2());
		client.setTelclt1(clt.getTelclt1());
		client.setTelclt2(clt.getTelclt2());
		client.setTelclt3(clt.getTelclt3());
		client.setValtmp(clt.getValtmp());
		client.setVilclt(clt.getVilclt());
		Client updatedClient = repository.save(client);
    	return updatedClient;
	}
}
