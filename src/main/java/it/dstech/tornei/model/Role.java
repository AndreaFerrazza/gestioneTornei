package it.dstech.tornei.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import it.dstech.tornei.model.base.BaseAbstract;

@Entity
public class Role extends BaseAbstract {

	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
