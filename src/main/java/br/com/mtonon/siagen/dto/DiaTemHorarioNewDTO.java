package br.com.mtonon.siagen.dto;

import java.io.Serializable;

public class DiaTemHorarioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean disponivel;
	private Integer diaId;
	private Integer horarioId;
	private Integer servicoId;
	private Integer unidadeSaudeId;
	
	public DiaTemHorarioNewDTO() {
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Integer getDiaId() {
		return diaId;
	}

	public void setDiaId(Integer diaId) {
		this.diaId = diaId;
	}

	public Integer getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public Integer getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(Integer unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}
	
}
