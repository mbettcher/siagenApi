package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nome_vacina", schema = "siagen_db")
public class NomeVacina implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nva_codigo")
	private Integer id;
	
	@Column(name = "nva_descricao", nullable = false, unique = true)
	private String nomeVacina;
	
	@Column(name = "nva_laboratorio", nullable = false)
	private String laboratorio;
	
	public NomeVacina() {
	}

	public NomeVacina(Integer id, String nomeVacina, String laboratorio) {
		super();
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.laboratorio = laboratorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
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
		NomeVacina other = (NomeVacina) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
