package com.ecolepratique.rapport.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Rapport;

public interface RapportRepositoryItf extends JpaRepository<Rapport, Long> {
	List<Rapport> findByBilanLike(String motcle);
	List<Rapport> findByMotifLike(String motcle);
	List<Rapport> findByDateAfter(LocalDate date);
	List<Rapport> findByDateBefore(LocalDate date);
}
