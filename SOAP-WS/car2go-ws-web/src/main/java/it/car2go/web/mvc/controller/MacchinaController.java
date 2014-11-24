package it.car2go.web.mvc.controller;




import it.car2go.servant.macchina.Macchina;
import it.car2go.servant.macchina.MacchinaServant;
import it.car2go.servant.macchina.MacchinaService;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MacchinaController {
	
	private MacchinaServant macchinaService;
	
	
	public MacchinaController(){
		MacchinaService ms = new MacchinaService();
		this.macchinaService = ms.getMacchinaServantPort();
	}
	
	
	@RequestMapping(value="/macchina/{id}")
	public String showMacchina(@PathVariable("id") int id, Model model){
		
		Macchina macchina = macchinaService.getMacchina(id);
		model.addAttribute(macchina);
		
		//in base alla benzina setto un valore		
		int benzina = macchina.getSerbatoio();
		
		if(benzina >= 50)
			model.addAttribute("livelloBenzina", "verde");
		if((benzina<50) && (benzina >= 20))
			model.addAttribute("livelloBenzina", "arancione");
		if(benzina < 20)
			model.addAttribute("livelloBenzina", "rosso");
		
		return "macchina";
	}

}
