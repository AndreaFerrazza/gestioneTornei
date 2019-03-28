package it.dstech.tornei.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.model.Partita;
import it.dstech.tornei.model.SquadraCompetizione;
import it.dstech.tornei.repository.PartitaRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class PartitaService extends GenericService<Partita,PartitaRepository> {

	@Autowired
	PartitaRepository repo;
	
	@Autowired
	SquadraCompetizioneService squadraService;
	
	public Partita creaPartita(Long idSquadraCasa,Long idSquadraOspite) throws BadRequestException {
		
		Partita partita = new Partita();		
		Optional<SquadraCompetizione> optionalSquadra = squadraService.findOne(idSquadraCasa);
		if(!optionalSquadra.isPresent()){
			throw new BadRequestException("0752", "Squadra non trovata");
		}		
		partita.setCasa(optionalSquadra.get());
		optionalSquadra = squadraService.findOne(idSquadraOspite);
		if(!optionalSquadra.isPresent()){
			throw new BadRequestException("0752", "Squadra non trovata");
		}
		partita.setOspite(optionalSquadra.get());
		
		return save(partita);
	}
	
}
