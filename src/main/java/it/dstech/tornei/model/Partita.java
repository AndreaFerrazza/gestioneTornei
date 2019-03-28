package it.dstech.tornei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class Partita extends BaseAbstract {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private SquadraCompetizione casa;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private SquadraCompetizione ospite;
	@Column(nullable = false)
	private Long goalCasa;
	@Column(nullable = false)
	private Long goalOspite;
	@Column(nullable = false)
	private Boolean conclusa;
	
	
	public SquadraCompetizione getCasa() {
		return casa;
	}
	public void setCasa(SquadraCompetizione casa) {
		this.casa = casa;
	}
	public SquadraCompetizione getOspite() {
		return ospite;
	}
	public void setOspite(SquadraCompetizione ospite) {
		this.ospite = ospite;
	}
	public Long getGoalCasa() {
		return goalCasa;
	}
	public void setGoalCasa(Long goalCasa) {
		this.goalCasa = goalCasa;
	}
	public Long getGoalOspite() {
		return goalOspite;
	}
	public void setGoalOspite(Long goalOspite) {
		this.goalOspite = goalOspite;
	}
	public Boolean getConclusa() {
		return conclusa;
	}
	public void setConclusa(Boolean conclusa) {
		this.conclusa = conclusa;
	}
	
	
	
}
