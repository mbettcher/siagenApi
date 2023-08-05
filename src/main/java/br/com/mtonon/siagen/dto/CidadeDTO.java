package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mtonon.siagen.domain.Cidade;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "O campo Nome da Cidade é de preenchimento obrigatório!")
	private String nome;
	
	@NotNull(message = "O campo ibge é de preenchimento obrigatório!")
	private Integer ibge;
	
	@NotNull(message = "O campo ibge7 é de preenchimento obrigatório!")
	private Integer ibge7;
	
	private Integer estado;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.ibge = obj.getIbge();
		this.ibge7 = obj.getIbge7();
		this.estado = obj.getEstado().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}	
}
