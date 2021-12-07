package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Servico;

public class UnidadeSaudeNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Boolean ativo;

	@NotBlank(message = "O campo telefone é obrigatório!")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	private List<EnderecoUnidadeSaude> enderecos = new ArrayList<>();

	private List<Especialidade> especialidades = new ArrayList<>();

	private List<Servico> servicos = new ArrayList<>();

	private List<DiaSemana> diasFuncionamento = new ArrayList<>();

	public UnidadeSaudeNewDTO() {
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
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
