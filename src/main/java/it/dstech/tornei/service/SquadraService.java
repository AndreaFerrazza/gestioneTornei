package it.dstech.tornei.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.dto.CreaSquadraDTO;
import it.dstech.tornei.model.Giocatore;
import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.repository.SquadraRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class SquadraService extends GenericService<Squadra, SquadraRepository>{

	@Autowired
	SquadraRepository repo;
	
	@Autowired
	GiocatoreService giocatoreService;
	
	public Squadra creaSquadra(CreaSquadraDTO squadraDTO) throws BadRequestException {
		Squadra squadra = new Squadra();
		Set<Long> giocatori = squadraDTO.getGiocatori();
		
		minimoGiocatori(giocatori.size());
		squadra.setSconfitte(0L);
		squadra.setVittorie(0L);
		squadra.getGiocatori().addAll(riempiSquadra(giocatori))	;
		squadra.setNome(squadraDTO.getNome());
		return save(squadra);
	}
	
	
	
	public Set<Giocatore> riempiSquadra(Set<Long> giocatoriDaInserire) throws BadRequestException{
		Set<Giocatore> inseriscili = new HashSet<>();
		for (Long long1 : giocatoriDaInserire) {
			Optional<Giocatore> trovati = giocatoreService.findOne(long1);
			if(!trovati.isPresent()) {
				throw new BadRequestException("0145", "Giocatore non trovato");
			}
			inseriscili.add(trovati.get());
		}
		return inseriscili;
	}
	
	
	public void minimoGiocatori(Integer componentiSquadra ) throws BadRequestException {
		if(componentiSquadra < 2) {
			throw new BadRequestException("0454", "Non ci sono abbastanza giocatori in lista");

		}
	}
	
	public List<Squadra> findAllByGiocatoreId(Long idGiocatore){
		return repo.findAllByGiocatoreId(idGiocatore);
	}
	
}
