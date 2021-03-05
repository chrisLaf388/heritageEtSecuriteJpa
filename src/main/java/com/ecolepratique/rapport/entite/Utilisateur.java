package com.ecolepratique.rapport.entite;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_UTILI")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private LocalDate dateEmbauche;
	
	public Utilisateur() {}
	public Utilisateur(Long id, String nom, LocalDate dateEmbauche) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", dateEmbauche=" + dateEmbauche + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	
	
	
}
