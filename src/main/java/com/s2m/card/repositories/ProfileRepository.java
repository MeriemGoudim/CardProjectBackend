package com.s2m.card.repositories;

import com.s2m.card.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long> {

}
