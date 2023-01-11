package com.eventoapp.service;

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
	
	public Iterable<Evento> buscaEventos(){
		Iterable<Evento> evento;
		evento = eventoRepository.findAll();
		return evento;
	}
}
