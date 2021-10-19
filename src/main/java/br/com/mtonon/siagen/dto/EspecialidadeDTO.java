package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.mtonon.siagen.domain.Especialidade;

public class EspecialidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo descrição é de preenchimento obrigatório")
	@Size(min = 5, max = 80, message = "O tamanho da descrição dever ser entre 5 e 80 caracteres")
	private String descricao;
	
	public EspecialidadeDTO() {
	}
	
	public EspecialidadeDTO(Especialidade obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
