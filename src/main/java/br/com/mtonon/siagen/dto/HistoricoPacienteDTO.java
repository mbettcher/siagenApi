package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.mtonon.siagen.domain.HistoricoPaciente;

public class HistoricoPacienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private LocalDateTime dataHistorico;
	
	private String observacao;
	
	private Integer paciente;
	
	public HistoricoPacienteDTO() {
	}
	
	public HistoricoPacienteDTO(HistoricoPaciente obj) {
		this.id = obj.getId();
		this.dataHistorico = obj.getDataHistorico();
		this.observacao = obj.getObservacao();
		this.paciente = obj.getPaciente().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHistorico() {
		return dataHistorico;
	}

	public void setDataHistorico(LocalDateTime dataHistorico) {
		this.dataHistorico = dataHistorico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}
}
