package it.dstech.tornei.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class Squadra extends BaseAbstract {

	@Column(nullable = false,unique = true)
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="squadre_giocatori",
	   joinColumns = {@JoinColumn (name = "Squadra_id")},
				inverseJoinColumns = { @JoinColumn(name = "giocatore_id")})
	private Set<Giocatore> giocatori;
	@Column(nullable = false)
	private Long vittorie;
	@Column(nullable = false)
	private Long sconfitte;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vincitore")
	//@JsonBackReference inutile con il JsonIgnore non verrebbe referenziato comunque
	@JsonIgnore
	private Set<Competizione> trofei;

	
	
	public Set<Giocatore> getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(Set<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
	public Long getVittorie() {
		return vittorie;
	}
	public void setVittorie(Long vittorie) {
		this.vittorie = vittorie;
	}
	public Long getSconfitte() {
		return sconfitte;
	}
	public void setSconfitte(Long sconfitte) {
		this.sconfitte = sconfitte;
	}
	public Set<Competizione> getTrofei() {
		return trofei;
	}
	public void setTrofei(Set<Competizione> trofei) {
		this.trofei = trofei;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
