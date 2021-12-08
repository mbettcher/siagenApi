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
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "especialidade")
public class Especialidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "esp_codigo")
	private Integer id;
	
	@Column(name = "esp_descricao", nullable = false, unique = true)
	private String descricao;
	
	/* Uma Especialidade tem várias Unidades de Saúde */
	@JsonIgnore
	@ManyToMany(mappedBy = "especialidades")
	private List<UnidadeSaude> unidadesSaude = new ArrayList<>();
	
	public Especialidade() {
	}

	public Especialidade(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
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
		Especialidade other = (Especialidade) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
