package br.com.mtonon.siagen.dto;

import java.io.Serializable;

public class HistoricoPacienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String observacao;

	private Integer paciente;
	
	public HistoricoPacienteNewDTO() {
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
