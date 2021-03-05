package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rapport {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDate date;
	@Column(columnDefinition = "TEXT") 
	private String bilan;
	private String motif;
	public Rapport() {}
	public Rapport(LocalDate date, String bilan, String motif) {
		super();
		this.date = date;
		this.bilan = bilan;
		this.motif = motif;
	}
	@Override
	public String toString() {
		return "\nRapport [id=" + id + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getBilan() {
		return bilan;
	}
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}	
}
