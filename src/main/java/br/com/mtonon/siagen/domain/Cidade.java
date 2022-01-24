package br.com.mtonon.siagen.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade", schema = "siagen_db")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_codigo")
	private Integer id;
	
	@Column(name = "cid_nome", nullable = false)
	private String nome;
	
	@Column(name = "cid_ibge")
	private Integer ibge;
	
	@Column(name = "cid_ibge7")
	private Integer ibge7;

	@ManyToOne
	@JoinColumn(name = "cid_estado_codigo")
	private Estado estado;
	
	public Cidade() {
	}

	public Cidade(Integer id, String nome, Integer ibge, Integer ibge7, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.ibge = ibge;
		this.ibge7 = ibge7;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}

	public Integer getIbge7() {
		return ibge7;
	}

	public void setIbge7(Integer ibge7) {
		this.ibge7 = ibge7;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}

}
