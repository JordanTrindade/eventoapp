package com.eventoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public void SalvaEvento(Evento evento) {
		eventoRepository.save(evento);
	}
	
	public Optional<Evento> buscaEvento(Long id){
	
		Optional<Evento> evento = eventoRepository.findById(id);
		return evento;
	}
	
	public Iterable<Evento> buscaListaEventos(){
		Iterable<Evento> evento;
		evento = eventoRepository.findAll();
		return evento;
	}
	
	public void deletaEvento(Evento evento) {
		eventoRepository.delete(evento);
	}
}
