package com.eventoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Tarefa;
import com.eventoapp.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	public void SalvaTarefa(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}
	
	public Iterable<Tarefa> buscaListaTarefas(){
		Iterable<Tarefa> tarefas;
		tarefas = tarefaRepository.findAll();
		return tarefas;
	}
}
