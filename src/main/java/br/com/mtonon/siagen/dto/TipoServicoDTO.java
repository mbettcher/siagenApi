package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.mtonon.siagen.domain.TipoServico;

public class TipoServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo é de preenchimento obrigatório!")
	@Size(min = 5, max = 100, message = "O tamanho com campo deve ser entre 5 a 100 caracteres!")
	private String nome;
	
	public TipoServicoDTO() {
	}
	
	public TipoServicoDTO(TipoServico obj) {
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
