package it.dstech.tornei.dto;

import java.util.Set;

public class CompetizioneDTO {
	
	private String nome;
	private Set<Long> idSquadrePartecipanti;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Long> getIdSquadrePartecipanti() {
		return idSquadrePartecipanti;
	}
	public void setIdSquadrePartecipanti(Set<Long> idSquadrePartecipanti) {
		this.idSquadrePartecipanti = idSquadrePartecipanti;
	}
		
	
}
