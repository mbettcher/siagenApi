package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Estado;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "O campo Nome da Cidade é de preenchimento obrigatório!")
	private String nome;
	
	@NotNull(message = "O campo Estado é de preenchimento obrigatório!")
	private Estado estado;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.estado = new Estado(obj.getEstado().getId(), obj.getEstado().getNome());
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
