package it.dstech.tornei.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.model.Giornata;
import it.dstech.tornei.model.Partita;
import it.dstech.tornei.model.SquadraCompetizione;
import it.dstech.tornei.repository.GiornataRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class GiornataService extends GenericService<Giornata,GiornataRepository> {

	@Autowired
	GiornataRepository repo;
	
	@Autowired
	PartitaService partitaService;
	
	
	public Giornata creaGiornata(SquadraCompetizione[] casa, SquadraCompetizione[] ospite) {
		Giornata giornata = new Giornata();
		
		Partita partita = new Partita();
		for(int i = 0; i < casa.length; i++) {
			partita.setCasa(casa[i]);
			partita.setOspite(casa[i]);
			giornata.getPartite().add(partita);
		}
		
		
		return giornata;
	}
	
	
	
	public Giornata creaGiornta(Set<SquadraCompetizione> squadre,Integer numeroGiornata) throws BadRequestException {
	
		Giornata giornata = new Giornata();
		giornata.setNumero(numeroGiornata);
		Set<Partita> accoppiamenti = new HashSet<>();
		
		Set<SquadraCompetizione> squadreDaUtilizzare = squadre;
			
		Long idCasa = 0L;
		Long idOspite = 0L;
		for (SquadraCompetizione squadraCompetizione : squadreDaUtilizzare) {
			idCasa = squadraCompetizione.getId();
			squadreDaUtilizzare.remove(squadraCompetizione);
		
			for (SquadraCompetizione squadraCompetizione2 : squadreDaUtilizzare) {
				idOspite = squadraCompetizione2.getId();
				squadreDaUtilizzare.remove(squadraCompetizione);
				break;
			}
			
			accoppiamenti.add(partitaService.creaPartita(idCasa, idOspite));			
		}
		giornata.setPartite(accoppiamenti);
		return giornata;
	}
	
}
