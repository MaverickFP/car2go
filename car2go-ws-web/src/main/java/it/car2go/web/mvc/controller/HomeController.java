package it.car2go.web.mvc.controller;



import it.car2go.servant.macchina.Macchina;
import it.car2go.servant.macchina.MacchinaServant;
import it.car2go.servant.macchina.MacchinaService;
import it.car2go.service.GeoService;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
	
	
	private MacchinaServant macchinaService;
	
	
	
	public HomeController(){
		
		MacchinaService ms = new MacchinaService();
		this.macchinaService = ms.getMacchinaServantPort();
		
	}
	
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model){
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();
		model.put("macchine", macchinaService.getMacchineNonPrenotate());
		model.put("totaleMacchine", size);		
		return "home";
	}
	
	
	
	@RequestMapping("/hello")
    public ModelAndView helloWorld() {
		

		
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();
		
		String message = "pippo";
        return new ModelAndView("home", "message", message);
	}
	

}
