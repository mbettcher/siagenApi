package br.com.mtonon.siagen.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServicoDTO implements Serializable{
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
	
	public ServicoDTO() {
	}

	public ServicoDTO(Integer id, String descricao, Integer tempoExecucao, 
			Integer idadeMinima, Integer idadeMaxima,
			String observacoes, Integer dose) {
		this.id = id;
		this.descricao = descricao;
		this.tempoExecucao = tempoExecucao;
		this.idadeMinima = idadeMinima;
		this.idadeMaxima = idadeMaxima;
		this.observacoes = observacoes;
		this.dose = dose;
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

}
