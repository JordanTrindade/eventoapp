package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@GetMapping(value = "/cadastrarEvento")
	public String cadastrarEvento() {
		return "evento/eventoFormulario";
	}
	
	@PostMapping(value = "/cadastrarEvento")
	public String cadastrarEvento(Evento evento, HttpServletResponse res) {
		eventoRepository.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
}
