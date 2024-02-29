package com.immobiliere.agent_immobiliere.Repos;

import com.immobiliere.agent_immobiliere.entities.Bien_immobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Bien_immobilierRepo extends JpaRepository<Bien_immobilier, Long> {
}
