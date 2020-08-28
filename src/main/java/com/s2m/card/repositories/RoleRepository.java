package com.s2m.card.repositories;

import com.s2m.card.models.ERole;
import com.s2m.card.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(ERole name);
}
