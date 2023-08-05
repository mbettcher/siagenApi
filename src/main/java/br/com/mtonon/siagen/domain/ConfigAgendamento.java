package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "config_agendamento", schema = "siagen_db")
public class ConfigAgendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cag_codigo")
	private Integer id;
	
	@Column(name = "cag_data_inicio", nullable = false)
	@FutureOrPresent(message = "A data de início do agendamento deve ser a data atual ou data futura")
	private LocalDate dataInicio;
	
	@Column(name = "cag_data_encerramento", nullable = false)
	@FutureOrPresent(message = "A data de encerramento do agendamento deve ser a data atual ou data futura")
	private LocalDate dataEncerramento;
	
	@Column(name = "cag_hora_inicio", nullable = false)
	private LocalTime horaInicio;
	
	@Column(name = "cag_hora_encerramento", nullable = false)
	private LocalTime horaEncerramento;
	
	@Column(name = "cag_iniciar_automaticamente", columnDefinition = "boolean default false")
	private boolean iniciarAutomaticamente;
	
	@Column(name = "cag_encerrar_automaticamente", columnDefinition = "boolean default false")
	private boolean encerrarAutomaricamente;
	
	@Column(name = "cag_ativo", columnDefinition = "boolean default false")
	private boolean ativo;
	
	public ConfigAgendamento() {
	}

	public ConfigAgendamento(Integer id, LocalDate dataInicio, LocalDate dataEncerramento,
			LocalTime horaInicio, LocalTime horaEncerramento,
			boolean iniciarAutomaticamente, boolean encerrarAutomaricamente, boolean ativo) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.horaInicio = horaInicio;
		this.horaEncerramento = horaEncerramento;
		this.iniciarAutomaticamente = iniciarAutomaticamente;
		this.encerrarAutomaricamente = encerrarAutomaricamente;
		this.ativo = ativo;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigAgendamento other = (ConfigAgendamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
