package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "funcionamento")
public class Funcionamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fun_codigo")
	private Integer id;
	
	@Column(name = "fun_abertura", nullable = false)
	private LocalTime horarioAbertura;
	
	@Column(name = "fun_fechamento", nullable = false)
	private LocalTime horaFechamento;
	
	@OneToMany(mappedBy = "funcionamento")
	private List<DiaSemana> diasSemana = new ArrayList<>();
	
	public Funcionamento() {
	}

	public Funcionamento(Integer id, LocalTime horarioAbertura, LocalTime horaFechamento) {
		super();
		this.id = id;
		this.horarioAbertura = horarioAbertura;
		this.horaFechamento = horaFechamento;
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
		Funcionamento other = (Funcionamento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
