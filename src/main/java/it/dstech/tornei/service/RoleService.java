package it.dstech.tornei.service;

import org.springframework.stereotype.Service;

import it.dstech.tornei.model.Role;
import it.dstech.tornei.repository.RoleRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class RoleService extends GenericService<Role, RoleRepository>{

	public Role findFirstByNome(String string) {
		return repository.findFirstByNome(string);		
	}

}
