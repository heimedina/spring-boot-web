package com.ideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
		
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required = false, defaultValue = "valor por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/various-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El texto enviado es: '"+saludo+"'"+" y el numero es '"+""+numero+"'");
		return "params/ver";
	}
	
	@GetMapping("/various-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El texto enviado es: '"+saludo+"'"+" y el numero es '"+""+numero+"'");
		return "params/ver";
	}

}
