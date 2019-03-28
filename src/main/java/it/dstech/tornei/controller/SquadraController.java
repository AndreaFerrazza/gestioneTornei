package it.dstech.tornei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.service.SquadraService;
import it.dstech.tornei.utill.MyConstants;

@RestController
@RequestMapping("/squadra")
public class SquadraController {

	@Autowired
	SquadraService service;
	
	@PreAuthorize("hasAnyRole('" + MyConstants.ROLE_USER+ "')")
	@RequestMapping(value = "/trovaSquadra/{idGiocatore}", method = RequestMethod.GET)
	public List<Squadra> findAllByGiocatoreId(@RequestParam (name = "idGiocatore") Long idGiocatore){
		return service.findAllByGiocatoreId(idGiocatore);
	}
	
}
