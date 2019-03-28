package it.dstech.tornei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.dstech.tornei.model.base.BaseAbstract;


@Entity
public class GiocatoreCompetizione extends BaseAbstract {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, unique = true)
	private Giocatore giocatore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,unique = true)
	private Competizione competizione;
	
	@Column(nullable = false)
	private Long goalSegnati;

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Competizione getCompetizione() {
		return competizione;
	}

	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}

	public Long getGoalSegnati() {
		return goalSegnati;
	}

	public void setGoalSegnati(Long goalSegnati) {
		this.goalSegnati = goalSegnati;
	}
	
	
	
}
