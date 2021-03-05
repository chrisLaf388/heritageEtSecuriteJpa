package com.ecolepratique.rapport.service;

import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.repository.RapportRepositoryItf;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RapportService implements RapportServiceItf {
	@Autowired
	private RapportRepositoryItf rapportRepository;
	
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public Rapport findRapportById(Long id) {
		//return rapportRepository.findById(id);
		return rapportRepository.findById(id).get();
	}
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public List<Rapport> listRapport() {
		return rapportRepository.findAll();
	}
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public Rapport updateRapport(Long id, Rapport rapport) {
		rapport.setId(id);
		return rapportRepository.save(rapport);
	}
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public Rapport deleteById(Long id) {
		Rapport rapport = findRapportById(id);
		rapportRepository.deleteById(id);
		return rapport;
	}
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public List<Rapport> listRapportByChampEtMotCle(String champ, String motCle){
		List<Rapport> rapports = null;
		if(champ.equals("motif")){
			rapports = rapportRepository.findByMotifLike("%" + motCle + "%");
		}
		else if(champ.equals("bilan")) {
			rapports = rapportRepository.findByBilanLike("%" + motCle + "%");
		}
		return rapports;
	}
	@RolesAllowed("ROLE_ADMIN")
	public List<Rapport> listRapportByDate(String date, String type){
		String[] tab = date.split("-"); 
		List<Rapport> rapports = null;
		if(type.equals("after"))
			rapports = rapportRepository.findByDateAfter(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		else if(type.equals("before"))
			rapports = rapportRepository.findByDateBefore(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		return rapports;
	}
}
