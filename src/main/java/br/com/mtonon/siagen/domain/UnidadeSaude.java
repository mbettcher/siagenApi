package br.com.mtonon.siagen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "usa_ativo", columnDefinition = "BOOLEAN")
	private Boolean ativo;
	
	@ElementCollection
	@CollectionTable(name = "unidade_saude_telefone")
	private Set<String> telefones = new HashSet<>();
	
	/* Uma Unidade de Saúde tem Um ou Muitos Especialidades */
	@ManyToMany
	@JoinTable(name = "unidade_saude_tem_especialidade",
			joinColumns = @JoinColumn(name = "unidade_saude_codigo"),
			inverseJoinColumns = @JoinColumn(name = "especialidade_codigo")
	)
	private List<Especialidade> especialidades = new ArrayList<>();
	
	/* Uma Unidade de Saúde tem Um ou Muitos Endereços ??? */
	@OneToMany(mappedBy = "unidadeSaude")
	private List<EnderecoUnidadeSaude> enderecos = new ArrayList<>();
	
	
	/* Uma UnidadeSaude tem Um ou Muitos Serviços */
	@ManyToMany
	@JoinTable(name = "unidade_saude_tem_servico", 
		joinColumns = @JoinColumn(name = "uss_unidade_saude_codigo"), 
		inverseJoinColumns = @JoinColumn(name = "uss_servico_codigo")
	)
	private List<Servico> servicos = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "unidade_saude_tem_dia_fucionamento", 
		joinColumns = @JoinColumn(name = "udf_unidade_saude_codigo"), 
		inverseJoinColumns = @JoinColumn(name = "udf_dia_semana_codigo")
	)
	private List<DiaSemana> diasFuncionamento = new ArrayList<>();
	
	/* Uma Unidade de Saúde tem um ou muitos Agendamentos */
	@OneToMany(mappedBy = "unidadeSaude")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
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
	
	@JsonIgnore
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<EnderecoUnidadeSaude> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoUnidadeSaude> enderecos) {
		this.enderecos = enderecos;
	}

	@JsonIgnore
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<DiaSemana> getDiasFuncionamento() {
		return diasFuncionamento;
	}

	public void setDiasFuncionamento(List<DiaSemana> diasFuncionamento) {
		this.diasFuncionamento = diasFuncionamento;
	}

	@JsonIgnore
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
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
		UnidadeSaude other = (UnidadeSaude) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
