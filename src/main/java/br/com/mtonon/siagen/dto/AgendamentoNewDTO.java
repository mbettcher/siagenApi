package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private boolean diaInteiro;
	private Integer statusEvento;
	private String titulo;
	private String descricao;
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private LocalTime horaInicio;
	
	private Integer pacienteId;
	private Integer unidadeSaudeId;
	private Integer servicoId;

	
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataFim() {
		return dataFim;
	}


	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Integer getPacienteId() {
		return pacienteId;
	}


	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	public Integer getUnidadeSaudeId() {
		return unidadeSaudeId;
	}


	public void setUnidadeSaudeId(Integer unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}


	public Integer getServicoId() {
		return servicoId;
	}


	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	
}
