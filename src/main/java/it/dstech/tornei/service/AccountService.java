package it.dstech.tornei.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.dstech.tornei.model.Account;
import it.dstech.tornei.model.Role;
import it.dstech.tornei.repository.AccountRepository;
import it.dstech.tornei.service.generic.GenericService;
import it.dstech.tornei.utill.MyConstants;
import it.dstech.tornei.config.exception.BadRequestException;

@Service
public class AccountService extends GenericService<Account, AccountRepository> {

	@Autowired
	AccountRepository repo;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Optional<Account> findFirstByUsername(String username) {
		return repo.findFirstByUsername(username);		
	}

	public void  verificaUsername(String username) throws BadRequestException {
		Optional<Account> optionalAccount = findFirstByUsername(username);
		if (optionalAccount.isPresent()) {
			throw new BadRequestException("002", "Esiste gia' un utente con questo username");
		}
	}

	public Account registraAccount(Account account) throws BadRequestException  {
		
		Account admin = new Account();
		admin.setUsername(account.getUsername());
		admin.setPassword(account.getPassword());
		verificaUsername(admin.getUsername());
		String encodePassword = passwordEncoder.encode(account.getPassword());
		admin.setPassword(encodePassword);
		Role roleAdmin = roleService.findFirstByNome("ROLE_"+ MyConstants.ROLE_ADMIN);
		admin.setRoles(roleAdmin);
		return save(admin);
	}

}
