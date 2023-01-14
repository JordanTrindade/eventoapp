package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventoapp.models.Tarefa;
import com.eventoapp.service.TarefaService;

@Controller
public class TarefaControler {
	
	@Autowired
	TarefaService tarefaSevice;

	@PostMapping("/{id}")
	public String adcionaTarefa(@PathVariable Long id,Tarefa tarefa) {
		tarefaSevice.SalvaTarefa(tarefa);
		
		return "redirect:/{id}";
	}
}
