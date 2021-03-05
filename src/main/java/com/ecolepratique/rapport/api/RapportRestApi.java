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
import com.ecolepratique.rapport.service.RapportServiceItf;

@RestController
@RequestMapping("/rapport")
@CrossOrigin("*")
public class RapportRestApi {
	@Autowired
	private RapportServiceItf rapportService;
	
	@GetMapping("")
	public List<Rapport> listRapport() {
		System.out.println("RapportRestApi - listRapport");
		return rapportService.listRapport();
	}
	@GetMapping("/{id}")
	public Rapport getRapportById(@PathVariable("id") Long id) {
		System.out.println("RapportRestApi - getRapportByVisiteur");
		return rapportService.findRapportById(id);
	}	
	@PutMapping("/{id}")
	public Rapport update(@PathVariable("id") Long id, @RequestBody Rapport rapport) {
		return rapportService.updateRapport(id, rapport);
	}
	@DeleteMapping("/{id}")
	public Rapport delete(@PathVariable("id") Long id) {
		return rapportService.deleteById(id);
	}
	@GetMapping(
			params = {"champ", "motcle"}
	)
	public List<Rapport> listRapportByChampEtMotCle(@RequestParam("champ") String champ, @RequestParam("motcle") String motCle) {
		System.out.println("RapportRestApi - listRapportByChampEtMotCle");
		return rapportService.listRapportByChampEtMotCle(champ, motCle);
	}
	@GetMapping(
			params = {"date", "type"}
	)
	public List<Rapport> listRapportByDate(@RequestParam("date") String date, @RequestParam("type") String type) {
		System.out.println("RapportRestApi - listRapportAfterDate");
		return rapportService.listRapportByDate(date, type);
	}
}
