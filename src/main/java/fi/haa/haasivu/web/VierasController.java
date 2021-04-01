package fi.haa.haasivu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haa.haasivu.domain.Vieras;
import fi.haa.haasivu.domain.VierasRepo;



@Controller
public class VierasController { 
	
	@Autowired
	private VierasRepo repo; 
	
	
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
		}
	 return "redirect:vieraslista";
	}

}
