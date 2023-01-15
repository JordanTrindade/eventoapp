package com.eventoapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.models.Evento;
import com.eventoapp.models.Tarefa;
import com.eventoapp.service.EventoService;
import com.eventoapp.service.TarefaService;

import jakarta.validation.Valid;

@Controller
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@Autowired
	private TarefaService tarefaService;

	@RequestMapping("/")
	public ModelAndView listaEventos() {

		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos;

		eventos = eventoService.buscaListaEventos();
		mv.addObject("eventos", eventos);

		return mv;
	}

	@GetMapping(value = "/cadastrarEvento")
	public String cadastrarEvento() {
		return "evento/eventoFormulario";
	}

	@PostMapping(value = "/cadastrarEvento")
	public String cadastrarEvento(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Todos os campos são obrigatório");
			return "redirect:/cadastrarEvento";
		}
		eventoService.SalvaEvento(evento);
		attributes.addFlashAttribute("mensagem", "Adicionado");
		return "redirect:/cadastrarEvento";
	}

	@RequestMapping("/{id}")
	public ModelAndView eventoDetalhes(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("evento/eventoDetalhes");
		Optional<Evento> eventoOp = eventoService.buscaEvento(id);
		Evento evento = eventoOp.get();

		Iterable<Tarefa> tarefas = tarefaService.buscaListaTarefas(evento);
		mv.addObject("evento", evento);
		mv.addObject("tarefas", tarefas);
		
		return mv;
	}

	@PostMapping("/{id}")
	public String adcionaTarefa(@PathVariable Long id, @Valid Tarefa tarefa, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique o campo nome");
			return "redirect:/{id}";
		}
		Optional<Evento> eventoOp = eventoService.buscaEvento(id);
		Evento evento = eventoOp.get();
		tarefa.setEvento(evento);
		tarefaService.SalvaTarefa(tarefa);

		attributes.addAttribute("mensagem", "tarefa adcionada!");

		return "redirect:/{id}";
	}

	@RequestMapping("/deletaEvento")
	public String deletaEvento(Long id) {

		Optional<Evento> eventoOP = eventoService.buscaEvento(id);
		Evento evento = eventoOP.get();
		eventoService.deletaEvento(evento);
		return "redirect:/";
	}

	@RequestMapping("/deletaTarefa")
	public String deleteTarefa(Long id) {	
		Optional<Tarefa> tarefaOP = tarefaService.buscaTarefa(id);
		Tarefa tarefa = tarefaOP.get();
		
		tarefaService.deletaTarefa(tarefa);
		Long eventoId = tarefa.getEvento().getId();
		System.out.println(tarefa.getEvento().getId());
		
		return "redirect:/" + eventoId;
	}
}
