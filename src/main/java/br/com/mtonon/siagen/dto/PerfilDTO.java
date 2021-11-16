package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.mtonon.siagen.domain.Perfil;

public class PerfilDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotBlank(message = "O campo perfil é de preenchimento obrigatório!")
	private String perfil;
	
	public PerfilDTO() {
	}
	
	public PerfilDTO(Perfil obj) {
		this.id = obj.getId();
		this.perfil = obj.getPerfil();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
