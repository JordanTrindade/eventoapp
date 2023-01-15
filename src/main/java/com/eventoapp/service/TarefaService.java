package com.eventoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Evento;
import com.eventoapp.models.Tarefa;
import com.eventoapp.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	public void SalvaTarefa(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}
	
	public Iterable<Tarefa> buscaListaTarefas(Evento evento){
		Iterable<Tarefa> tarefas;
		tarefas = tarefaRepository.findByEvento(evento);
		return tarefas;
	}
	
	public Optional<Tarefa> buscaTarefa(Long id){
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa;
	}
		
	public void deletaTarefa(Tarefa tarefa) {
		tarefaRepository.delete(tarefa);
	}
}
