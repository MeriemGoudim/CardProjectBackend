package com.s2m.card.repositories;

import com.s2m.card.models.InfosCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfosCardRepository extends CrudRepository<InfosCard,Long> {

}
