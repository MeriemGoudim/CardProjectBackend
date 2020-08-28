package com.s2m.card.services;

import com.s2m.card.exception.ResourceNotFoundException;
import com.s2m.card.models.InfosCard;
import com.s2m.card.repositories.InfosCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InfosCardService {
    @Autowired
    private InfosCardRepository repository;

    public List<InfosCard> getAllInfosCards() {
        return (List<InfosCard>)repository.findAll();
    }

    public InfosCard create(InfosCard card) {
    	card.setStatut("En cours");
        return repository.save(card);
    }

    public Optional<InfosCard> getInfosCardById(long id){
        return repository.findById(id);
    }
    public void delete(Long id) throws ResourceNotFoundException {
    	InfosCard infosCard=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("InfosCard not found for this id :: " + id));
    	repository.delete(infosCard);
    }
    
    public InfosCard update(Long id,InfosCard card) throws ResourceNotFoundException {
    	InfosCard infosCard=repository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("InfosCard not found for this id :: " + id));
		infosCard.setAutresEffets(card.getAutresEffets());
		infosCard.setBin(card.getBin());
		infosCard.setCapacitePuce(card.getCapacitePuce());
		infosCard.setClient(card.getClient());
		infosCard.setCouleurImp(card.getCouleurImp());
		infosCard.setCouleurRecto(card.getCouleurRecto());
		infosCard.setCouleurVerso(card.getCouleurVerso());
		infosCard.setDateApprobationVisaMc(card.getDateApprobationVisaMc());
		infosCard.setDateBonCdeS2M(card.getDateBonCdeS2M());
		infosCard.setDateEnlevement(card.getDateEnlevement());
		infosCard.setDateEnvoiPdfClt(card.getDateEnvoiPdfClt());
		infosCard.setDateEnvoiPdfCltVr1(card.getDateEnvoiPdfCltVr1());
		infosCard.setDateEnvoiPdfCltVr2(card.getDateEnvoiPdfCltVr2());
		infosCard.setDateEnvoiPdfCltVr3(card.getDateEnvoiPdfCltVr3());
		infosCard.setDateEnvoiVisuelFr(card.getDateEnvoiVisuelFr());
		infosCard.setDateExpPuce(card.getDateExpPuce());
		infosCard.setDateFacture(card.getDateFacture());
		infosCard.setDateReception(card.getDateReception());
		infosCard.setDateReceptionChromalin(card.getDateReceptionChromalin());
		infosCard.setDateReceptionFV(card.getDateReceptionFV());
		infosCard.setDateReceptionS2M(card.getDateReceptionS2M());
		infosCard.setDateResoumissionVisaMc(card.getDateResoumissionVisaMc());
		infosCard.setDateSoumissionVisaMc(card.getDateSoumissionVisaMc());
		infosCard.setDateValidationClt(card.getDateValidationClt());
		infosCard.setDemandeBatClt(card.getDemandeBatClt());
		infosCard.setEffetsSpeciaux(card.getEffetsSpeciaux());
		infosCard.setFabriquantPuce(card.getFabriquantPuce());
		infosCard.setFacturationLivraison(card.getFacturationLivraison());
		infosCard.setFinition(card.getFinition());
		infosCard.setFournisseur(card.getFournisseur());
		infosCard.setHologramme(card.getHologramme());
		infosCard.setIca(card.getIca());
		infosCard.setContact(card.getContact());
		infosCard.setContactLess(card.getContactLess());
		infosCard.setIntituleCarte(card.getIntituleCarte());
		infosCard.setLaminat(card.getLaminat());
		infosCard.setMasquePuce(card.getMasquePuce());
		infosCard.setNumBonCdeS2M(card.getNumBonCdeS2M());
		infosCard.setNumFacture(card.getNumFacture());
		infosCard.setCommentaire(card.getCommentaire());
		infosCard.setNumSoumission(card.getNumSoumission());
		infosCard.setCda(card.getCda());
		infosCard.setPaiement(card.getPaiement());
		infosCard.setPuce(card.getPuce());
		infosCard.setPiste(card.getPiste());
		infosCard.setDda(card.getDda());
		infosCard.setSda(card.getSda());
		infosCard.setStatut(card.getStatut());
		infosCard.setPanneauSignature(card.getPanneauSignature());
		infosCard.setQuantite(card.getQuantite());
		infosCard.setRefVisaMc(card.getRefVisaMc());
		infosCard.setRefVisuel(card.getRefVisuel());
		infosCard.setScheime(card.getScheime());
		infosCard.setTypeImpRecto(card.getTypeImpRecto());
		infosCard.setTypeProduit(card.getTypeProduit());
		infosCard.setTypePuce(card.getTypePuce());
		infosCard.setUser(card.getUser());
		InfosCard updatedInfosCard = repository.save(infosCard);
    	return updatedInfosCard;
    	
    }
}
