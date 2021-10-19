package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.mtonon.siagen.domain.Estado;

public class EstadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo é de preenchimento obrigatório")
	@Size(min = 4, max = 80, message = "O tamanho dever ser entre 4 e 80 caracteres")
	private String nome;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Estado obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
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

}
