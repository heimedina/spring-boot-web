package com.ideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/","home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring Framework");
		
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Heidi");
		usuario.setApellido("Medina");
		usuario.setEmail("heidi@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Luis","Perez","correo1@gmail.com"),
				new Usuario("Andres","Guzman","correo2@gmail.com"),new Usuario("Raul","Gonzalez","correo3@gmail.com"),
				new Usuario("Pablo","Medina","pablo3@gmail.com"));
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
		
	}

}
