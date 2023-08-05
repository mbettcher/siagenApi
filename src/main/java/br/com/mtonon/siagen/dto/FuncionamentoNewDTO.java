package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalTime;

public class FuncionamentoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private LocalTime horarioAbertura;
	private LocalTime horaFechamento;
	
	public FuncionamentoNewDTO() {
	}

	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public LocalTime getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(LocalTime horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
}
