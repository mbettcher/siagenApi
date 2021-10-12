package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "unidade_saude")
public class UnidadeSaude implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usa_codigo")
	private Integer id;
	
	@Column(name = "usa_nome")
	private String nome;
	
	@Column(name = "usa_data_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "usa_data_alteracao")
	private LocalDateTime dataAlteracao;
	
	@Column(name = "usa_ativo", columnDefinition = "BOOLEAN", nullable = false)
	private Boolean ativo;
	
	/* Uma Unidade de Saúde tem Uma ou Várias Especialidades */
	@ManyToMany
	@JoinTable(name = "unidade_saude_tem_especialidade",
			joinColumns = @JoinColumn(name = "unidade_saude_codigo"),
			inverseJoinColumns = @JoinColumn(name = "especialidade_codigo")
	)
	private List<Especialidade> especialidades = new ArrayList<>();
	
	public UnidadeSaude() {
	}

	public UnidadeSaude(Integer id, String nome, LocalDateTime dataCadastro, LocalDateTime dataAlteracao,
			Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.ativo = ativo;
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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
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
		UnidadeSaude other = (UnidadeSaude) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
