package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;

public class UnidadeSaudeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Boolean ativo;

	private Set<String> telefones = new HashSet<>();

	private List<EnderecoUnidadeSaude> enderecos = new ArrayList<>();

	private List<Especialidade> especialidades = new ArrayList<>();

	private List<Servico> servicos = new ArrayList<>();

	private List<DiaSemana> diasFuncionamento = new ArrayList<>();

	public UnidadeSaudeDTO() {
	}

	public UnidadeSaudeDTO(UnidadeSaude obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.ativo = obj.getAtivo();
		this.telefones = obj.getTelefones();
		this.enderecos = obj.getEnderecos();
		this.especialidades = obj.getEspecialidades();
		this.servicos = obj.getServicos();
		this.diasFuncionamento = obj.getDiasFuncionamento();
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

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
}
