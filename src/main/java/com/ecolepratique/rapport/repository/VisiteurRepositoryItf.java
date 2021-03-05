package com.ecolepratique.rapport.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Visiteur;

public interface VisiteurRepositoryItf extends JpaRepository<Visiteur, Long> {
	List<Visiteur> findByDateEmbaucheAfter(LocalDate date);
	List<Visiteur> findByDateEmbaucheBefore(LocalDate date);
}
