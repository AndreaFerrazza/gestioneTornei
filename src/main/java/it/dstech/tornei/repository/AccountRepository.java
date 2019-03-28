package it.dstech.tornei.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.dstech.tornei.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{

	Optional<Account> findFirstByUsername(String username);

}
