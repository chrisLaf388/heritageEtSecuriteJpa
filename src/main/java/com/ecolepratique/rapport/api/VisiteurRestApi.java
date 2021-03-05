package com.ecolepratique.rapport.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.VisiteurServiceItf;

@RestController
@RequestMapping("/visiteur")
@CrossOrigin("*")
public class VisiteurRestApi {
	@Autowired
	private VisiteurServiceItf visiteurService;
	
	@GetMapping("")
	public List<Visiteur> listVisiteur() {
		System.out.println("RapportRestApi - listVisteur");
		List<Visiteur> visiteurs = visiteurService.listVisiteur();
		//System.out.println("VisiteurRestApi - listVisteur visiteurs=" + visiteurs);
		return visiteurs;
	}
	@GetMapping("/{id}")
	public Visiteur getVisiteur(@PathVariable("id") Long id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return visiteurService.findVisiteurById(id);
	}
	@PostMapping("")
	public Visiteur createVisiteur(@RequestBody Visiteur visiteur) {
		System.out.println("VisiteurRestApi - create visiteur=" + visiteur);
        return visiteurService.createVisiteur(visiteur);
	}
	@PutMapping("/{id}")
	public Visiteur updateVisiteur(@PathVariable("id") Long id, @RequestBody Visiteur visiteur) {
		return visiteurService.updateVisiteurByid(id, visiteur);
	}
	@DeleteMapping("/{id}")
	public Visiteur deleteVisiteur(@PathVariable("id") Long id) {
		return visiteurService.deleteVisiteurById(id);
	}
	@GetMapping("/{id}/rapport")
	public List<Rapport> listRapportByIdVisiteur(@PathVariable("id") Long idVisiteur) {
		System.out.println("VisiteurRestApi - getRapportByVisiteur");
		return visiteurService.listRapportByIdVisiteur(idVisiteur);
	}
	@PostMapping("/{id}/rapport")
	public Rapport create(@PathVariable("id") Long idVisiteur, @RequestBody Rapport rapport) {
        return visiteurService.createRapport(idVisiteur, rapport);
	}	
	@GetMapping(
			params = {"date", "type"}
	)
	public List<Visiteur> listVisiteurEmbaucheByDate(@RequestParam("date") String date, @RequestParam("type") String type) {
		System.out.println("RapportRestApi - listRapportAfterDate");
		return visiteurService.listVisiteurEmbaucheByDate(date, type);
	}
}
