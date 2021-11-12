package br.com.mtonon.siagen.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import br.com.mtonon.siagen.domain.Dia;

public class DiaDTO {

	private Integer id;
	
	@NotEmpty(message = "O campor data é de preenchimento obrigatório.")
	@FutureOrPresent(message = "A data informada deve ser a data atual ou uma data futura.")
	private LocalDate data;
	
	public DiaDTO() {
	}
	
	public DiaDTO(Dia obj) {
		this.id = obj.getId();
		this.data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
