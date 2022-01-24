package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dia_semana", schema = "siagen_db")
public class DiaSemana implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dse_codigo")
	private Integer id;
	
	@Column(name = "dse_dia", nullable = false)
	private String dia;
	
	@Column(name = "dse_ativo", columnDefinition = "BOOLEAN", nullable = false)
	private boolean ativo;

	@ManyToOne
	@JoinColumn(name = "dse_funcionamento_codigo")
	private Funcionamento funcionamento;
	
	@ManyToMany(mappedBy = "diasFuncionamento")
	private List<UnidadeSaude> unidadesSaude = new ArrayList<>();
	
	public DiaSemana() {
	}

	public DiaSemana(Integer id, String dia, boolean ativo, Funcionamento funcionamento) {
		super();
		this.id = id;
		this.dia = dia;
		this.ativo = ativo;
		this.funcionamento = funcionamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Funcionamento getFuncionamento() {
		return funcionamento;
	}

	public void setFuncionamento(Funcionamento funcionamento) {
		this.funcionamento = funcionamento;
	}

	@JsonIgnore
	public List<UnidadeSaude> getUnidadesSaude() {
		return unidadesSaude;
	}

	public void setUnidadesSaude(List<UnidadeSaude> unidadesSaude) {
		this.unidadesSaude = unidadesSaude;
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
		DiaSemana other = (DiaSemana) obj;
		return Objects.equals(id, other.id);
	}

}
