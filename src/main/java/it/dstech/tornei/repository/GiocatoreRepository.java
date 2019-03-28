package it.dstech.tornei.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.dstech.tornei.model.Account;
import it.dstech.tornei.model.Giocatore;

public interface GiocatoreRepository extends CrudRepository<Giocatore,Long>{

	Optional<Giocatore> findFirstByAccount(Account account);
	
}
