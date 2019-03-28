package it.dstech.tornei.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.dstech.tornei.model.SquadraCompetizione;

public interface SquadraCompetizioneRepository extends CrudRepository<SquadraCompetizione, Long> {

	public Set<SquadraCompetizione> findBySquadraGiocatoriId(Long idGiocatore);
	
}
