package it.dstech.tornei.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class Giocatore extends BaseAbstract {

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private Long partiteGiocate;
	@Column(nullable = false)
	private Long goalSegnati;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false,unique = true)
	@JsonIgnore
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Long getPartiteGiocate() {
		return partiteGiocate;
	}
	public void setPartiteGiocate(Long partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}
	public Long getGoalSegnati() {
		return goalSegnati;
	}
	public void setGoalSegnati(Long goalSegnati) {
		this.goalSegnati = goalSegnati;
	}
	
	
}
