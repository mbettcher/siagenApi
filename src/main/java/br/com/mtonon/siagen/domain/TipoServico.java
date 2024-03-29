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
import javax.persistence.OneToMany;

import br.com.mtonon.siagen.dto.TipoServicoDTO;

@Entity(name = "tipo_servico")
public class TipoServico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tse_codigo")
	private Integer id;
	
	@Column(name = "tse_descricao", length = 100, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "tipoServico")
	private List<Servico> servicos = new ArrayList<>(); 
	
	public TipoServico() {
	}
	
	public TipoServico(TipoServicoDTO objDTO) {
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
	}

	public TipoServico(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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
		TipoServico other = (TipoServico) obj;
		return Objects.equals(id, other.id);
	}

}
