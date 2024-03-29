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
import javax.persistence.Table;

@Entity
@Table(name = "horario", schema = "siagen_db")
public class Horario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hor_codigo")
	private Integer id;
	
	@Column(name = "hor_hora", nullable = false, unique = true)
	private LocalTime hora;
	
	@OneToMany(mappedBy = "horario")
	private List<DiaTemHorario> agendamentos = new ArrayList<>();
	
	public Horario() {
	}

	public Horario(Integer id, LocalTime hora) {
		this.id = id;
		this.hora = hora;
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
		Horario other = (Horario) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
