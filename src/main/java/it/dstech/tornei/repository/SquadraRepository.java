package it.dstech.tornei.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.tornei.model.Squadra;

public interface SquadraRepository extends CrudRepository<Squadra, Long> {

	public List<Squadra> findAllByGiocatoreId(Long idGiocatore);
	
}
