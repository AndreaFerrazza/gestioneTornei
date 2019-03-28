package it.dstech.tornei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.tornei.config.exception.BadRequestException;
import it.dstech.tornei.dto.RegistrazioneGiocatoreDTO;
import it.dstech.tornei.model.Giocatore;
import it.dstech.tornei.service.GiocatoreService;
import it.dstech.tornei.utill.MyConstants;

@RestController
@RequestMapping("/giocatore")
public class GiocatoreController {

	@Autowired
	GiocatoreService service;
	
	@RequestMapping(value = "/public/", method = RequestMethod.POST)
	public Giocatore creaGiocatore(@RequestBody RegistrazioneGiocatoreDTO giocatoreDTO) throws BadRequestException {
		return service.creaGiocatore(giocatoreDTO);
	}
	
	@PreAuthorize("hasAnyRole('" + MyConstants.ROLE_USER+ "')")
	@RequestMapping(value = "/vedi", method = RequestMethod.POST)
	public Giocatore vediProfiloGiocatore() throws BadRequestException {
		return service.vediProfiloGiocatore();
	}
	
}
