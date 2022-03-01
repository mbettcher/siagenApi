package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "dia", schema = "siagen_db")
public class Dia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dia_codigo")
	private Integer id;
	
	@Column(name = "dia_data", nullable = false, unique = true)
	@FutureOrPresent(message = "A data deve ser o dia de hoje ou uma data futura!")
	private LocalDate data;
	
	@OneToMany(mappedBy = "dia")
	private List<DiaTemHorario> agendamentos = new ArrayList<>();
	
	public Dia() {
	}

	public Dia(Integer id, LocalDate data) {
		super();
		this.id = id;
		this.data = data;
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
	

	public List<DiaTemHorario> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<DiaTemHorario> agendamentos) {
		this.agendamentos = agendamentos;
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
		Dia other = (Dia) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
