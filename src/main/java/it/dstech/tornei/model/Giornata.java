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
public class Giornata  extends BaseAbstract{

	@Column(nullable = false)
	private Integer numero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Competizione competizione;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false,name = "giornate_id")
	@JsonIgnore
	private Set<Partita> partite;
	
	@Column(nullable = false)
	private Boolean conclusa;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Competizione getCompetizione() {
		return competizione;
	}
	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}
	
	public Set<Partita> getPartite() {
		return partite;
	}
	public void setPartite(Set<Partita> partite) {
		this.partite = partite;
	}
	public Boolean getConclusa() {
		return conclusa;
	}
	public void setConclusa(Boolean conclusa) {
		this.conclusa = conclusa;
	}
	
	
	
}
