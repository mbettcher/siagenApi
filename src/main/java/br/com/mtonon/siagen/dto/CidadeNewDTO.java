package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CidadeNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O campo Nome da Cidade é de preenchimento obrigatório!")
	private String nome;
	
	@NotNull(message = "O campo ibge é de preenchimento obrigatório!")
	private Integer ibge;
	
	@NotNull(message = "O campo ibge7 é de preenchimento obrigatório!")
	private Integer ibge7;
	
	@NotNull(message = "O campo Estado é de preenchimento obrigatório!")
	private Integer estadoId;

	
	public CidadeNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public Integer getIbge7() {
		return ibge7;
	}

	public void setIbge7(Integer ibge7) {
		this.ibge7 = ibge7;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

}
