package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServicoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotBlank(message = "O campo descrição é obrigatório!")
	private String descricao;
	
	@NotNull(message = "O Campo tempo de execução é obrigatório")
	private Integer tempoExecucao;
	
	@NotNull(message = "O Campo idade mínima é obrigatório")
	private Integer idadeMinima;
	
	@NotNull(message = "O Campo idade máxima é obrigatório")
	private Integer idadeMaxima;
	
	private String observacoes;
	
	@NotNull(message = "O Campo dose é obrigatório")
	private Integer dose;
	
	@NotNull(message = "O Campo Tipo de Serviço é obrigatório")
	private Integer tipoServicoId;
	
	private Integer nomeVacina;
	
	@NotNull(message = "O Campo Unidade de Saúde é obrigatório")
	private Integer unidadeSaudeId;
	
	public ServicoNewDTO() {
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

	public Integer getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Integer tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public Integer getTipoServicoId() {
		return tipoServicoId;
	}

	public void setTipoServicoId(Integer tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}

	public Integer getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(Integer unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}

	public Integer getNomeVacina() {
		return nomeVacina;
	}


	public void setNomeVacina(Integer nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
}
