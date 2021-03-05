package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class Visiteur extends Utilisateur{
	@OneToMany
	private List<Rapport> rapports;
	



	public Visiteur(Long id, String nom, LocalDate dateEmbauche, List<Rapport> rapports) {
		super(id, nom, dateEmbauche);

		rapports = new ArrayList<>();
	}


	public Visiteur(Long id, String nom, LocalDate dateEmbauche) {
		super(id, nom, dateEmbauche);
		// TODO Auto-generated constructor stub
	}


	public void addRapport(Rapport rapport) {
		rapports.add(rapport);
	}
	
	
	public List<Rapport> getRapports() {
		return rapports;
	}
	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}
}
