package it.dstech.tornei.dto;

import java.util.Set;

import it.dstech.tornei.model.Competizione;
import it.dstech.tornei.model.Giornata;

public class CalendarioDTO {

	private Competizione competizione;
	
	private Set<Giornata> calendario;

	public Competizione getCompetizione() {
		return competizione;
	}

	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}

	public Set<Giornata> getCalendario() {
		return calendario;
	}

	public void setCalendario(Set<Giornata> calendario) {
		this.calendario = calendario;
	}
	
	
}
