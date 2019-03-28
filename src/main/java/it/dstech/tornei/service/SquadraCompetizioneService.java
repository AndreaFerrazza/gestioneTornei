package it.dstech.tornei.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.tornei.dto.findDTO;
import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.model.SquadraCompetizione;
import it.dstech.tornei.repository.SquadraCompetizioneRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class SquadraCompetizioneService extends GenericService<SquadraCompetizione, SquadraCompetizioneRepository> {

	@Autowired
	SquadraCompetizioneRepository repo;
	
	@Autowired
	GiocatoreService giocatoreService;
	
	
	public SquadraCompetizione creaSquadraCompetizione(Squadra squadra) {
		SquadraCompetizione squadraCompetizione = new SquadraCompetizione();
		squadraCompetizione.setSquadra(squadra);
		squadraCompetizione.setGiocate(0L);
		squadraCompetizione.setGoalFatti(0L);
		squadraCompetizione.setGoalSubiti(0L);
		squadraCompetizione.setPareggio(0L);
		squadraCompetizione.setPerse(0L);
		squadraCompetizione.setPunti(0L);
		squadraCompetizione.setVinte(0L);
		
		return save(squadraCompetizione);
	}
	
	
	public findDTO findBySquadraGiocatoriId(){
	
		//ricorda
		return null;
	}
	
}
