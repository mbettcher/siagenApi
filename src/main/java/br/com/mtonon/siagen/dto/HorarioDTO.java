package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import br.com.mtonon.siagen.domain.Horario;

public class HorarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "O campo hora é de preenchimento obrigatório.")
	private LocalTime hora;
	
	public HorarioDTO() {
	}
	
	public HorarioDTO(Horario obj) {
		this.id = obj.getId();
		this.hora = obj.getHora();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
}
