package it.dstech.tornei.dto;

import java.util.Set;

public class CreaSquadraDTO {

	private String nome;
	
	private Set<Long> giocatori;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Long> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Long> giocatori) {
		this.giocatori = giocatori;
	}

	
	
}
