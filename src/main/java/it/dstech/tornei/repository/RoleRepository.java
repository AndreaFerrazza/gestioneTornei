package it.dstech.tornei.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.tornei.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findFirstByNome(String string);

}
