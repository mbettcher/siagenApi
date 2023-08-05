package br.com.mtonon.siagen.dto;

import java.io.Serializable;

public class AgendamentoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean diaInteiro;
	private Integer statusEvento;
	private String titulo;
	
	private Integer agendaId;
	private Integer pacienteId;

	
	public AgendamentoNewDTO() {
	}


	public boolean isDiaInteiro() {
		return diaInteiro;
	}


	public void setDiaInteiro(boolean diaInteiro) {
		this.diaInteiro = diaInteiro;
	}


	public Integer getStatusEvento() {
		return statusEvento;
	}


	public void setStatusEvento(Integer statusEvento) {
		this.statusEvento = statusEvento;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Integer getPacienteId() {
		return pacienteId;
	}


	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	public Integer getAgendaId() {
		return agendaId;
	}


	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

}
