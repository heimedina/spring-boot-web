package com.ideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class RoutController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo","Enviar parametros de la ruta (@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo","Recibir parametros de la ruta @PathVariable");
		model.addAttribute("resultado","El texto enviado a la ruta es: "+texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo","Recibir parametros de la ruta @PathVariable");
		model.addAttribute("resultado","El texto enviado a la ruta es: "+texto
				+" y el nuemro enviado en el path es: "+numero);
		return "variables/ver";
	}

}
