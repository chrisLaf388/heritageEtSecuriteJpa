package com.ecolepratique.rapport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Utilisateur;

public interface UtilisateurDaoItf extends JpaRepository <Utilisateur, Long> {

}
