package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.Funcionamento;

public class FuncionamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private LocalTime horarioAbertura;

	private LocalTime horaFechamento;

	private List<DiaSemana> diasSemana = new ArrayList<>();

	public FuncionamentoDTO() {
	}

	public FuncionamentoDTO(Funcionamento obj) {
		this.id = obj.getId();
		this.horarioAbertura = obj.getHorarioAbertura();
		this.horaFechamento = obj.getHoraFechamento();
		this.diasSemana = obj.getDiasSemana();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<DiaSemana> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<DiaSemana> diasSemana) {
		this.diasSemana = diasSemana;
	}

}
