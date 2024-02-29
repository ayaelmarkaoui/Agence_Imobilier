package com.immobiliere.agent_immobiliere.Repos;

import com.immobiliere.agent_immobiliere.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
}
