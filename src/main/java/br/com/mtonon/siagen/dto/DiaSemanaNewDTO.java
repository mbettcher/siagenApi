package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DiaSemanaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O campo Dia da Semana é de preenchimento obrigatório!")
	private String dia;
	
	private boolean ativo;
	
	@NotNull(message = "Obrigatório informar um horário de funcionamento")
	private Integer funcionamentoId;

	public DiaSemanaNewDTO() {
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getFuncionamentoId() {
		return funcionamentoId;
	}

	public void setFuncionamentoId(Integer funcionamentoId) {
		this.funcionamentoId = funcionamentoId;
	}
}
