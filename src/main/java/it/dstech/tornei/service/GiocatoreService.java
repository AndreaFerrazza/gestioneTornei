package it.dstech.tornei.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.dstech.tornei.service.security.AuthenticationUtil;
import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.dto.RegistrazioneGiocatoreDTO;
import it.dstech.tornei.model.Account;
import it.dstech.tornei.model.Giocatore;
import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.repository.GiocatoreRepository;
import it.dstech.tornei.service.generic.GenericService;
import it.dstech.tornei.utill.MyConstants;

@Service
public class GiocatoreService extends GenericService<Giocatore,GiocatoreRepository> {

	@Autowired
	GiocatoreRepository repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SquadraService squadraService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RoleService roleService;
	
	public Giocatore creaGiocatore(RegistrazioneGiocatoreDTO giocatoreDTO) throws BadRequestException {
		
		Giocatore giocatore = new Giocatore();
		giocatore.setNome(giocatoreDTO.getNome());
		giocatore.setCognome(giocatoreDTO.getCognome());
		giocatore.setGoalSegnati(0L);
		giocatore.setPartiteGiocate(0L);
		
		
		Account account = new Account();
		account.setUsername(giocatoreDTO.getUsername());
		account.setPassword(giocatoreDTO.getPassword());
		accountService.verificaUsername(account.getUsername());
		String encodedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		account.setRoles(roleService.findFirstByNome("ROLE_" + MyConstants.ROLE_USER));
		accountService.save(account);
		
		return save(giocatore);
			
	}
	
	public Giocatore getLoggedGiocaotre() throws BadRequestException {
		Optional<Account> optionalAccount = accountService.findFirstByUsername(AuthenticationUtil.getUsername());
		if (!optionalAccount.isPresent()) {
			throw new BadRequestException("003", "Cliente non trovato");
		}
		Optional<Giocatore> optionalGiocatore= findFirstByAccount(optionalAccount.get());
		return optionalGiocatore.get();
	}

	private Optional<Giocatore> findFirstByAccount(Account account) {		
		return repository.findFirstByAccount(account);
	}

	public Giocatore vediProfiloGiocatore() throws BadRequestException {
		return getLoggedGiocaotre();
	}
	
	
	public List<Squadra> vediSquadre() throws BadRequestException{
		return squadraService.findAllByGiocatoreId(getLoggedGiocaotre().getId());
	}
	
	
	
}
