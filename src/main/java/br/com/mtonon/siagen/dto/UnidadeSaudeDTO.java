package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.mtonon.siagen.domain.UnidadeSaude;

public class UnidadeSaudeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAlteracao;
	private Boolean ativo;
	
	public UnidadeSaudeDTO() {
	}
	
	public UnidadeSaudeDTO(UnidadeSaude obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataCadastro = obj.getDataCadastro();
		this.dataAlteracao = obj.getDataAlteracao();
		this.ativo = obj.getAtivo();
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
}
