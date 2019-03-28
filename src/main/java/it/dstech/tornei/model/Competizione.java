package it.dstech.tornei.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class Competizione extends BaseAbstract {

	@Column(nullable = false,unique = true)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonManagedReference inutile perchè dall'altro lato c'è qualcosa
	private Squadra vincitore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private Giocatore capocannoniere;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "competizione_id")
	private Set<SquadraCompetizione> squadre;
	
	private Boolean conclusa;
	
	public Set<SquadraCompetizione> getSquadre() {
		return squadre;
	}
	public void setSquadre(Set<SquadraCompetizione> squadre) {
		this.squadre = squadre;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Boolean getConclusa() {
		return conclusa;
	}
	public void setConclusa(Boolean conclusa) {
		this.conclusa = conclusa;
	}
	
	
	
	
	
}
