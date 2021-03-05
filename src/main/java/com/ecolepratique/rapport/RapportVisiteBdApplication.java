package com.ecolepratique.rapport;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.repository.RapportRepositoryItf;
import com.ecolepratique.rapport.repository.UserDaoItf;
import com.ecolepratique.rapport.repository.UserRoleDaoItf;
import com.ecolepratique.rapport.repository.UtilisateurDaoItf;
import com.ecolepratique.rapport.repository.VisiteurRepositoryItf;
import com.ecolepratique.rapport.service.VisiteurServiceItf;


@SpringBootApplication
public class RapportVisiteBdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RapportVisiteBdApplication.class, args);
		VisiteurRepositoryItf visiteurDao = ctx.getBean(VisiteurRepositoryItf.class);
		UserDaoItf userDao = ctx.getBean(UserDaoItf.class);
		UserRoleDaoItf userRoleDao = ctx.getBean(UserRoleDaoItf.class);
		UtilisateurDaoItf utilisateurDao = ctx.getBean(UtilisateurDaoItf.class);
		userDao.save(new User("uadmin", "padmin"));
		userDao.save(new User("uuser", "puser"));
		
		userRoleDao.save(new UserRole("uadmin","ADMIN"));
		userRoleDao.save(new UserRole("uadmin","USER"));
		userRoleDao.save(new UserRole("uuser","USER"));
		
		Visiteur visiteur1 = new Visiteur(1L,"coco", LocalDate.of(2020, 6, 12));
		System.out.println(visiteur1);
		
		Utilisateur utilisateur1 = new Utilisateur(2L,"elo", LocalDate.of(2012, 6, 12));
		System.out.println(utilisateur1);
		visiteurDao.save(visiteur1);
		Utilisateur utilisateur2 = new Visiteur(3L, "Lola", LocalDate.of(2015, 7, 11));
		utilisateurDao.save(utilisateur1);
		utilisateurDao.save(utilisateur2);

	}
}


