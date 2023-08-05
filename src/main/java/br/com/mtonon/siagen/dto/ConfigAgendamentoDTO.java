package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.FutureOrPresent;

import br.com.mtonon.siagen.domain.ConfigAgendamento;

public class ConfigAgendamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@FutureOrPresent(message = "A data informada deve ser a data atual ou data futura!")
	private LocalDate dataInicio;
	@FutureOrPresent(message = "A data informada deve ser a data atual ou data futura!")
	private LocalDate dataEncerramento;
	private LocalTime horaInicio;
	private LocalTime horaEncerramento;
	private boolean iniciarAutomaticamente;
	private boolean encerrarAutomaricamente;
	private boolean ativo;
	
	public ConfigAgendamentoDTO() {
	}
	
	public ConfigAgendamentoDTO(ConfigAgendamento obj) {
		this.id = obj.getId();
		this.dataInicio = obj.getDataInicio();
		this.dataEncerramento = obj.getDataEncerramento();
		this.horaInicio = obj.getHoraInicio();
		this.horaEncerramento = obj.getHoraEncerramento();
		this.iniciarAutomaticamente = obj.isIniciarAutomaticamente();
		this.encerrarAutomaricamente = obj.isEncerrarAutomaricamente();
		this.ativo = obj.isAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraEncerramento() {
		return horaEncerramento;
	}

	public void setHoraEncerramento(LocalTime horaEncerramento) {
		this.horaEncerramento = horaEncerramento;
	}

	public boolean isIniciarAutomaticamente() {
		return iniciarAutomaticamente;
	}

	public void setIniciarAutomaticamente(boolean iniciarAutomaticamente) {
		this.iniciarAutomaticamente = iniciarAutomaticamente;
	}

	public boolean isEncerrarAutomaricamente() {
		return encerrarAutomaricamente;
	}

	public void setEncerrarAutomaricamente(boolean encerrarAutomaricamente) {
		this.encerrarAutomaricamente = encerrarAutomaricamente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
