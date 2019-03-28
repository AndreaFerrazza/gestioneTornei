package it.dstech.tornei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class SquadraCompetizione extends BaseAbstract {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, unique = true)
	private Squadra squadra;

	@Column(nullable = false)
	private Long giocate;
	@Column(nullable = false)

	private Long vinte;
	@Column(nullable = false)

	private Long perse;
	@Column(nullable = false)

	private Long pareggio;
	@Column(nullable = false)

	private Long goalFatti;
	@Column(nullable = false)

	private Long goalSubiti;
	@Column(nullable = false)

	private Long punti;

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}



	public Long getGiocate() {
		return giocate;
	}

	public void setGiocate(Long giocate) {
		this.giocate = giocate;
	}

	public Long getVinte() {
		return vinte;
	}

	public void setVinte(Long vinte) {
		this.vinte = vinte;
	}

	public Long getPerse() {
		return perse;
	}

	public void setPerse(Long perse) {
		this.perse = perse;
	}

	public Long getGoalFatti() {
		return goalFatti;
	}

	public void setGoalFatti(Long goalFatti) {
		this.goalFatti = goalFatti;
	}

	public Long getGoalSubiti() {
		return goalSubiti;
	}

	public void setGoalSubiti(Long goalSubiti) {
		this.goalSubiti = goalSubiti;
	}

	public Long getPunti() {
		return punti;
	}

	public void setPunti(Long punti) {
		this.punti = punti;
	}

	public Long getPareggio() {
		return pareggio;
	}

	public void setPareggio(Long pareggio) {
		this.pareggio = pareggio;
	}

}
