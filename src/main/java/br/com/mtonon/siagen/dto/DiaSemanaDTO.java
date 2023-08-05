package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.Funcionamento;

public class DiaSemanaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String dia;
	
	private boolean ativo;
	
	private Funcionamento funcionamento;
	
	public DiaSemanaDTO() {
	}
	
	public DiaSemanaDTO(DiaSemana obj) {
		this.id = obj.getId();
		this.dia = obj.getDia();
		this.ativo = obj.isAtivo();
		this.funcionamento = obj.getFuncionamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Funcionamento getFuncionamento() {
		return funcionamento;
	}

	public void setFuncionamento(Funcionamento funcionamento) {
		this.funcionamento = funcionamento;
	}
}
