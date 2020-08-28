package com.s2m.card.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.s2m.card.models.AppeletVersion;

@Repository
public interface AppeletVersionRepository extends CrudRepository<AppeletVersion, Long>{

}
