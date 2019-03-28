package it.dstech.tornei.dto;

import java.util.Set;

import it.dstech.tornei.model.Giocatore;
import it.dstech.tornei.model.Squadra;
import it.dstech.tornei.model.SquadraCompetizione;

public class findDTO {

	private String nomeCompetizione;
	private Squadra vincitore;
	private Giocatore capocannoniere;
	
	private Set<SquadraCompetizione> classifica;

	public String getNomeCompetizione() {
		return nomeCompetizione;
	}

	public void setNomeCompetizione(String nomeCompetizione) {
		this.nomeCompetizione = nomeCompetizione;
	}

	public Squadra getVincitore() {
		return vincitore;
	}

	public void setVincitore(Squadra vincitore) {
		this.vincitore = vincitore;
	}

	public Giocatore getCapocannoniere() {
		return capocannoniere;
	}

	public void setCapocannoniere(Giocatore capocannoniere) {
		this.capocannoniere = capocannoniere;
	}

	public Set<SquadraCompetizione> getClassifica() {
		return classifica;
	}

	public void setClassifica(Set<SquadraCompetizione> classifica) {
		this.classifica = classifica;
	}
	
	
	
}
