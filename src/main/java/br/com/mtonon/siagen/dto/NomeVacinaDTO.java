package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.mtonon.siagen.domain.NomeVacina;

public class NomeVacinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	@NotBlank(message = "O campo Nome da Vacina é de preenchimento obrigatório!")
	@Size(min = 5, max = 45, message = "O comprimento do Nome da Vacina deve estar entre 5 e 45 caracteres.")
	private String nomeVacina;
	
	@NotBlank(message = "O campo Laboratório é de preenchimento obrigatório!")
	@Size(min = 5, max = 160, message = "O comprimento do Nome do Laboratório deve estar entre 5 e 160 caracteres.")
	private String laboratorio;
	
	public NomeVacinaDTO() {
	}
	
	public NomeVacinaDTO(NomeVacina obj) {
		this.id = obj.getId();
		this.nomeVacina = obj.getNomeVacina();
		this.laboratorio = obj.getLaboratorio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
}
