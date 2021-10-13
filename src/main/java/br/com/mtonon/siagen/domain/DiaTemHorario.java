package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "dia_has_horario")
public class DiaTemHorario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dhh_codigo")
	private Integer id;
	
	@Column(name = "dhh_disponivel", columnDefinition = "BOOLEAN", nullable = false)
	private boolean disponivel;
	
	@ManyToOne
	@JoinColumn(name = "dhh_dia_codigo")
	private Dia dia;
	
	@ManyToOne
	@JoinColumn(name = "dhh_hor_codigo")
	private Horario horario;
	
	public DiaTemHorario() {
	}

	public DiaTemHorario(Integer id, boolean disponivel, Dia dia, Horario horario) {
		super();
		this.id = id;
		this.disponivel = disponivel;
		this.dia = dia;
		this.horario = horario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
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
		DiaTemHorario other = (DiaTemHorario) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
