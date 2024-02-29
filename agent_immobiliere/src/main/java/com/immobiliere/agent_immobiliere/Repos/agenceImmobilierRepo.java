package com.immobiliere.agent_immobiliere.Repos;


import com.immobiliere.agent_immobiliere.entities.Agence_immobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface agenceImmobilierRepo extends JpaRepository<Agence_immobilier, Long> {
}
