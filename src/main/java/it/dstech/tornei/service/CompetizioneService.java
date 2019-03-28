package it.dstech.tornei.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.dto.CalendarioDTO;
import it.dstech.tornei.dto.CompetizioneDTO;
import it.dstech.tornei.model.Competizione;
import it.dstech.tornei.model.Giornata;
import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.model.SquadraCompetizione;
import it.dstech.tornei.repository.CompetizioneRepository;
import it.dstech.tornei.service.generic.GenericService;

@Service
public class CompetizioneService extends GenericService<Competizione, CompetizioneRepository>{
	
	@Autowired
	CompetizioneRepository repo;
	
	@Autowired
	SquadraService squadraService;
	
	@Autowired
	PartitaService partitaService;
	
	@Autowired
	GiornataService giornataService;
	
	@Autowired
	SquadraCompetizioneService squadraCompetizioneService;
	
	public Competizione creaCompetizione(CompetizioneDTO competizioneDTO) throws BadRequestException {
		
		Competizione competizione = new Competizione();
		
		SquadraCompetizione squadraDaInserire = new SquadraCompetizione();
		
		competizione.setNome(competizioneDTO.getNome());
		
		for (Long idSquadraDaInserire : competizioneDTO.getIdSquadrePartecipanti()) {
			Optional<Squadra> squadraOptional = squadraService.findOne(idSquadraDaInserire);
			if(!squadraOptional.isPresent()) {
				throw new BadRequestException("0777", "Squadra non trovata");
			}
			
			squadraDaInserire = squadraCompetizioneService.creaSquadraCompetizione(squadraOptional.get());	
			competizione.getSquadre().add(squadraDaInserire);	
		}
		competizione.setConclusa(false);
		return save(competizione);		
	}
	
	public CalendarioDTO creaCalendario(Long idCompetizione) throws BadRequestException {
		
		CalendarioDTO calendarioCompetizione = new CalendarioDTO();
		
		Optional<Competizione> campionatoCalendario = findOne(idCompetizione);
		if(!campionatoCalendario.isPresent()) {
			throw new BadRequestException("0254", "Competizione non trovata");
		}
		calendarioCompetizione.setCompetizione(campionatoCalendario.get());
		
		Set<SquadraCompetizione>squadre = campionatoCalendario.get().getSquadre();
		SquadraCompetizione[] squadrette = (SquadraCompetizione[]) squadre.toArray();
		
		SquadraCompetizione[] casa = null ;
		SquadraCompetizione[] ospite = null;
		
		for(int i = 0 ; i< squadrette.length; i++) {
			if(i< (squadrette.length / 2) ) {
				casa[i] = squadrette[i];
			}else {
				ospite[i- casa.length] = squadrette[i];
			}
		}
	
		
		
	}
	

	public Set<Giornata> algoritmoMioDiBergByMe(SquadraCompetizione[] casa, SquadraCompetizione[] ospite){
		
		SquadraCompetizione riporto = new SquadraCompetizione();
		SquadraCompetizione resto = new SquadraCompetizione();

		Set<Giornata> giornata = new HashSet<>();
		
		
		for(int i = 0; i < casa.length;i++) {
			riporto = casa[1];
			resto = ospite[ospite.length - 1];
			
			//metodo crea giornate da riscrevere
			
			for(int j = 1; j < casa.length - 1; j++){
				casa[j] = casa[j + 1] ;
				ospite[casa.length-j] = ospite[casa.length-j-1];
			}
			
			casa[casa.length -1 ] = resto;
			ospite[0] = riporto;
			
			
		}
		
		return giornata;
		
	}
	
}
