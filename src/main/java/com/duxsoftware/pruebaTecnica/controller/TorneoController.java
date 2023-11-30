package com.duxsoftware.pruebaTecnica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.duxsoftware.pruebaTecnica.modelo.Partido;
import com.duxsoftware.pruebaTecnica.service.TorneoService;

@Controller
public class TorneoController {
	
	@Autowired
	TorneoService torneo;
	
	@GetMapping("/")
	public String inicio(Model model) {
		return "home";
	}

	@PostMapping("/crear")
	public String crearPartido(Partido partido, Model model) {
		Partido p = torneo.jugarPartido(partido);
		model.addAttribute("nombreTorneo", p.getNombreTorneo());
		model.addAttribute("partido", p);
		List<Integer> listF1 = new ArrayList<>();
		List<Integer> listF2 = new ArrayList<>();
		for (int i = 0; i < p.getPuntos()[0].length; i++) {
			listF1.add(p.getPuntos()[0][i]);
			}
		for (int j = 0; j < p.getPuntos()[1].length; j++){
			listF2.add(p.getPuntos()[1][j]);
			}
		model.addAttribute("lista1", listF1);
		model.addAttribute("lista2", listF2);
		return "/home";
	}

	@GetMapping("/jugarPartido")
	public String jugarPartido() {
		System.out.print("partido");
		return "/home";
	}
	
}
