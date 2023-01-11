package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@GetMapping(value = "/cadastrarEvento")
	public String cadastrarEvento() {
		return "evento/eventoFormulario";
	}

	@PostMapping(value = "/cadastrarEvento")
	public String cadastrarEvento(Evento evento) {
		eventoRepository.save(evento);

		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos;
		
		eventos = eventoRepository.findAll();
		mv.addObject("eventos", eventos);
		
		return mv;
	}
}
