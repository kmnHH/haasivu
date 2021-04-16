package fi.haa.haasivu.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haa.haasivu.domain.Vieras;
import fi.haa.haasivu.domain.VierasRepo;




@Controller
public class VierasController { 
	
	@Autowired
	private VierasRepo repo; 
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	public long laskeVieraat() { 
		
		return repo.count();
	} 
	
	@RequestMapping(value="/vieraslista")
	public String vierasLista(Model model) {
	model.addAttribute("vieraat", repo.findAll());
	return "vieraslista";
	} 
	
	@RequestMapping(value = "/")
	public String lisaaVieras(Model model){
	 model.addAttribute("vieras", new Vieras());
	 return "lisaaVieras"; 
	} 
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String tallennaOsallistujat(Vieras vieras){
		if(vieras.getOsallistuminen().equals("Kyllä")) {
			repo.save(vieras);   
			return "tervetuloa";
		} else { 
	 return "harmi"; 
		}
	}  
	
	 @PreAuthorize("hasAuthority('ADMIN')")
	 @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET) 
	 	public String muokkaaVieras(@PathVariable("id") Long vierasId, Model model) { 
		Optional <Vieras> vieras = repo.findById(vierasId);
		 model.addAttribute("vieras", vieras); 
		 return "muokkaavieras";
	 }   
	 
	 @PreAuthorize("hasAuthority('ADMIN')")
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String poistaVieras(@PathVariable("id") Long vierasId, Model model) {
	    	repo.deleteById(vierasId);
	        return "redirect:../vieraslista";
	    }     

}
