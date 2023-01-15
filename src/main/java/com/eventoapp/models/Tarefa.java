package com.eventoapp.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Tarefa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nome;
	private String inicio;
	private String fim;

	@ManyToOne
	private Evento evento;

	public Tarefa() {
		super();
	}

	public Tarefa(Long id, String nome, String inicio, String fim, Evento evento) {
		super();
		this.id = id;
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
		this.evento = evento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

}
