package com.s2m.card.repositories;

import com.s2m.card.models.Client;
import com.s2m.card.models.InfosCard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfosCardRepository extends CrudRepository<InfosCard,Long> {
	Optional<InfosCard> findByClient(Client client);
	
	@Query(value="select card.* from infoscards card where card.id_client= ?1 and card.statut='En cours'", nativeQuery = true)
    List<InfosCard> findByClientAndStatutEncours(Long idClient);
	
	@Query(value="select card.* from infoscards card where card.id_client= ?1 and card.statut='Cloturé'", nativeQuery = true)
    List<InfosCard> findByClientAndStatutCloture(Long idClient);
}
