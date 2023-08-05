package br.com.mtonon.siagen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.domain.enums.Dose;

public class DiaTemHorarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private boolean disponivel;
	
	private Integer diaId;
	private LocalDate data;
	
	private Integer horarioId;
	private LocalTime hora;
	
	private Integer servicoId;
	private String descricaoServico;
	private Integer idadeMinimaServico;
	private Integer idadeMaximaServico;
	private String observacoesServico;
	private Dose dose;
	
	private Integer nomeVacinaId;
	private String nomeVacina;
	private String laboratorio;
	
	private Integer tipoServicoId;
	private String tipoServico;
	
	private Integer unidadeSaudeId;
	private String unidadeSaude;
	
	public DiaTemHorarioDTO() {
	}
	
	public DiaTemHorarioDTO(DiaTemHorario obj) {
		this.id = obj.getId();
		this.disponivel = obj.isDisponivel();
		this.diaId = obj.getDia().getId();
		this.data = obj.getDia().getData();
		this.horarioId = obj.getHorario().getId();
		this.hora = obj.getHorario().getHora();
		this.servicoId = obj.getServico().getId();
		this.descricaoServico = obj.getServico().getDescricao();
		this.idadeMinimaServico = obj.getServico().getIdadeMinima();
		this.idadeMaximaServico = obj.getServico().getIdadeMaxima();
		this.observacoesServico = obj.getServico().getObservacoes();
		this.dose = obj.getServico().getDose();
		this.nomeVacinaId = obj.getServico().getNomeVacina().getId();
		this.nomeVacina = obj.getServico().getNomeVacina().getNomeVacina();
		this.laboratorio = obj.getServico().getNomeVacina().getLaboratorio();
		this.tipoServicoId = obj.getServico().getTipoServico().getId();
		this.tipoServico = obj.getServico().getTipoServico().getNome();
		this.unidadeSaudeId = obj.getUnidadeSaude().getId();
		this.unidadeSaude = obj.getUnidadeSaude().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Integer getIdadeMinimaServico() {
		return idadeMinimaServico;
	}

	public void setIdadeMinimaServico(Integer idadeMinimaServico) {
		this.idadeMinimaServico = idadeMinimaServico;
	}

	public Integer getIdadeMaximaServico() {
		return idadeMaximaServico;
	}

	public void setIdadeMaximaServico(Integer idadeMaximaServico) {
		this.idadeMaximaServico = idadeMaximaServico;
	}

	public String getObservacoesServico() {
		return observacoesServico;
	}

	public void setObservacoesServico(String observacoesServico) {
		this.observacoesServico = observacoesServico;
	}

	public Dose getDose() {
		return dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	public Integer getNomeVacinaId() {
		return nomeVacinaId;
	}

	public void setNomeVacinaId(Integer nomeVacinaId) {
		this.nomeVacinaId = nomeVacinaId;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Integer getTipoServicoId() {
		return tipoServicoId;
	}

	public void setTipoServicoId(Integer tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Integer getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(Integer unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}

	public String getUnidadeSaude() {
		return unidadeSaude;
	}

	public void setUnidadeSaude(String unidadeSaude) {
		this.unidadeSaude = unidadeSaude;
	}

}
