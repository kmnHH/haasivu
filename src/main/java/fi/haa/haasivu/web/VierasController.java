package fi.haa.haasivu.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haa.haasivu.domain.EiTulevatRepo;
import fi.haa.haasivu.domain.EiVieras;
import fi.haa.haasivu.domain.Vieras;
import fi.haa.haasivu.domain.VierasRepo;




@Controller
public class VierasController { 
	
	@Autowired
	private VierasRepo repo;  
	
	@Autowired
	private EiTulevatRepo eiTulevatRepo;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value="/vieraslista")
	public String vierasLista(Model model) { 
	//tallennetaan model-olioon kaikki vieraat vierasrepositorysta ja viedään ne vieraslista thymeleafille
	model.addAttribute("vieraat", repo.findAll()); 
	model.addAttribute("eiTulevat", eiTulevatRepo.findAll());
	return "vieraslista";
	} 
	
	@RequestMapping(value = "/")
	public String lisaaVieras(Model model){ 
	// luodaan uusi vieras ja lisätään se vierasrepositoryyn	
	 model.addAttribute("vieras", new Vieras());
	 return "lisaaVieras"; 
	} 
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String tallennaOsallistujat(Vieras vieras){ 
		// mikäli vieraan vastaa osallistumiseen "Kyllä", hänet tallennetaan vierasrepositoryyn ja selain ohjautuu tervetuloa thymeleaf sivulle
		if(vieras.getOsallistuminen().equals("Kyllä")) {
			repo.save(vieras);   
			return "tervetuloa"; 
		// mikäli vastaus on jotakin muuta, ohjataan selain harmi thymeleaf sivulle	
		} else {   
			// Vieras-oliosta muutetaan EiVieras-olio, luomalla ensin uusi EiVieras-olio ja tallentamalla sille Vieras-olion tietoja
			EiVieras eivieras = new EiVieras(); 
			eivieras.setEtunimi(vieras.getEtunimi());   
			eivieras.setSukunimi(vieras.getSukunimi());
			eiTulevatRepo.save(eivieras);
			return "harmi"; 
		}
	}  
	
	 @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET) 
	 	public String muokkaaVieras(@PathVariable("id") Long vierasId, Model model) { 
		// mahdollistetaan vieraan tietojen muokkaaminen hyödyntämällä vieraan id-arvoa ja tallentamalla uudet tiedot vieraan olion
		 Optional <Vieras> vieras = repo.findById(vierasId);
		 model.addAttribute("vieras", vieras); 
		 return "muokkaavieras";
	 }   
	 
	 @PreAuthorize("hasAuthority('ADMIN')") 
	 //mahdollistetaan vieraan tietojen poistaminen admin tunnuksilla
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String poistaVieras(@PathVariable("id") Long vierasId, Model model) {
	    	repo.deleteById(vierasId);
	        return "redirect:../vieraslista";
	    }     

}
